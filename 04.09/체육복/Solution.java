import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 최대값을 결정하는 변수 = 최대 학생수 - 잃어버린 학생수 로 
        int max = n - lost.length;
        
        // 인접한 번호를 가진 학생 체크
        for (int i = 0; i < lost.length; i++)
            for (int j = 0; j < reserve.length; j++)
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    max++;  // 여분을 가진 학생이 인접했을경우 추가
                    break;
                }
        
        for (int i = 0; i < lost.length; i++)
            for (int j = 0; j < reserve.length; j++)
                if (Math.abs(lost[i] - reserve[j]) == 1) {
                    reserve[j] = -1;
                    max++;
                    break;
                }

        return max;
    }
}
