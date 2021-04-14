import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        int release,next,pre;
        Queue<Integer> que = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        // 각 작업마다 완료까지 필요한 일 수를 미리 구해서 큐에 담기
        for(int i=0;i<progresses.length;i++){
            int calc = (100-progresses[i]) % speeds[i];
            int result = (100-progresses[i]) / speeds[i];
            progresses[i] = calc==0?result:result+1;
            que.add(progresses[i]);
        }

        // 이전 작업과 다음 작업을 비교 후 이전 작업이 더 늦게 끝나면 배포수 증가
        pre = que.poll();
        release = 1;
        while(!que.isEmpty()){
                next = que.poll();
                if(pre>=next){
                    release++;
                }else{
                    list.add(release);
                    release=1;
                    pre = next;
                }
        }

        list.add(release);
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}