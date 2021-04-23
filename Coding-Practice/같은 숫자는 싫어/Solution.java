import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();

        // 밑에서 이전 인덱스를 비교해줄 것이기 때문에 첫 숫자를 리스트에 넣어줌
        list.add(arr[0]);

        // 이전 인덱스와 값이 같지 않을경우 연속되지 않으니 값을 넣어줌
        for(int i=1;i<arr.length;i++){
            if(arr[i-1] != arr[i])
                list.add(arr[i]);
        }

        // 리턴해줄 배열형 선언
        int[] answer = new int[list.size()];

        // 리스트 값을 배열로 옮겨줌
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}