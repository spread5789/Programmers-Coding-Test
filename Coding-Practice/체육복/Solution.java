import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 최대값을 결정하는 변수 = 최대 학생수 - 잃어버린 학생수 로 
        int max = n - lost.length;
        
        // 본인이 잃어버렸지만, 여분을 가지고 있었을 경우 먼저 체크
        for (int i = 0; i < lost.length; i++)
            for (int j = 0; j < reserve.length; j++)
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;            // 받았거나, 여분을 빌려줬을 경우 확인을 위해 -1로 체크
                    reserve[j] = -1;
                    max++;  // 여분을 가진 학생이 인접했을경우 추가
                    break;
                }
        
        // 잃어버렸고, 다른 친구에게 여분을 빌릴 경우 (그리도 알고리즘 특성 상, 이렇게 위에서 1번, 여기서 1번 체크해줘야한다.)
        for (int i = 0; i < lost.length; i++)
            for (int j = 0; j < reserve.length; j++)
                if (Math.abs(lost[i] - reserve[j]) == 1) { // 절대값으로, 바로 옆번호인 친구일 
                    reserve[j] = -1;
                    max++;
                    break;
                }

        return max;
    }
}
