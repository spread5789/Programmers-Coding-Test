import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // challange : 해당 스테이지를 도전중인 플레이어 수
		// clear : 해당 스테이지를 클리어 한 플레이어 수
		// map<스테이지 번호,실패율>
        int challange = 0;
        double clear;
        HashMap<Integer,Double> map = new HashMap<>();
        
        // 실패율 = 스테이지 도달 인원 / (도달 + 클리어 한 인원
        // i = stages 탐색 변수 (각 플레이어들의 스테이지 현황)
        // j = 각 스테이지
        for(int j=1;j<=N;j++){
            clear = 0;
            challange = 0;
            for(int i=0;i<stages.length;i++){
                if(j < stages[i]){              // 스테이지를 클리어 했을 때
                    clear++;    // 클리어 한 인원 수
                } else if( j == stages[i]){     // 스테이지에 도달만 했을 때
                    challange++;
                }
            }
			// 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
            if(clear == 0 && challange == 0){
                map.put(j,0.);
                continue;
            }
            map.put(j,challange/(clear+challange));
        }
        // key = 스테이지, value = 실패율
        
        // list 의 sort 매소드를 이용하여 map 의 Value를 기준으로 정렬
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
		
        // list 를 배열로 옮겨줌
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++)
            answer[i]=list.get(i);

        return answer;
    }
}