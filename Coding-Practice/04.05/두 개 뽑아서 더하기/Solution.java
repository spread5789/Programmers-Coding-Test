import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();

        // 리스트에 담겨져있지 않은 원소 추가
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(!list.contains(numbers[i]+numbers[j]))
                    list.add(numbers[i]+numbers[j]);
            }
        }

        // 정렬
        Collections.sort(list);

        // 배열로 옮겨주기
        int[] answer = new int[list.size()];
        int size = 0;
        for(int i : list)
            answer[size++] = i;

        return answer;
    }
}