import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        
        // A-Z 까지 사전에 추가 [키:문자   값:색인번호]
        int index = 1;
        for(char i='A';i<='Z';i++){
            hm.put(i+"",index++);
        }
        
        for(int i=0;i<msg.length();i++){
            String word = msg.charAt(i)+"";
            int end = i+1;
            // 가장 긴 단어 확인
            while(end<=msg.length()){
                if(end==msg.length()){  // 종료조건 : msg 의 끝까지 탐색했을때
                    list.add(hm.get(msg.substring(i)));
                    i = end;
                    break;
                }
                    
                String nextword = msg.substring(i,end+1);
                if(hm.containsKey(nextword)){
                    end++;
                }else{
                    word = msg.substring(i,end);
                    list.add(hm.get(word));
                    hm.put(nextword, hm.size()+1);
                    i = end-1;
                    break;
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}