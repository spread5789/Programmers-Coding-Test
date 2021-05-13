import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        // 처음 값을 임시로 최저값으로 넣어줌.
        int min = arr[0];
        ArrayList<Integer> list = new ArrayList<>();
        
        // 최저값 찾기
        for(int i=0; i<arr.length;i++){
            if(arr[i] < min)
                min = arr[i];
        }
        
        // 최저값과 일치하는 값을 제외하고 list에 넣어줌
        for(int i=0;i<arr.length;i++){
            if(min != arr[i])
                list.add(arr[i]);
        }
        // list 가 비어있다면 -1 리턴
        if(list.isEmpty())
            return new int[]{-1};
        
        int[] answer = new int[list.size()];
        
        // list -> array 변환
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}