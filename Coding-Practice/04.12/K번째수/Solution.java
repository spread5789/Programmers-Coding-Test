import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {

        // commands 의 크기만큼 answer의 크기가 결정되려면..
        int[] answer = new int[commands.length];

        // commands 의 [x]-1 부터 [y] 까지 자른 후 sort 후 [z]-1 번째를 배열에 담기
        for(int i = 0;i<commands.length;i++)    // 위 주석을 commands 의 column 마다 반복 후 담기
        {
            int[] arr = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2]-1];
        }

        return answer;
    }
}