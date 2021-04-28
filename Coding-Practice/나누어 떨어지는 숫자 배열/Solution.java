import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
		// divisor 로 나누어 떨어지는 수 담기
        for(int i=0;i<arr.length;i++)
            if(arr[i] % divisor == 0)
                list.add(arr[i]);
        
		// 나누어 떨어지는 수가 없을경우 -1 배열형으로 리턴
        if(list.size()==0) return new int[]{-1};
		
        int[] answer = new int[list.size()];
		
        // 배열에 옮겨담기
        for(int i=0;i<answer.length;i++)
            answer[i] = list.get(i);
        
		// 정렬
        Arrays.sort(answer);
    
        return answer;
    }
}