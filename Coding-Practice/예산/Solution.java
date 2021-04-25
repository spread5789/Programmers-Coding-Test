import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        // temp : 현재까지 사용한 예산
        int temp = 0;
        // answer : 몇개의 부서들에게 물품을 사줬는지
        int answer = 0;
        Arrays.sort(d);

        for(int i=0;i<d.length;i++)
            // 예산을 적게 신청한 부서 순으로 물품을 구매하는데 이때 총 예산을 초과하지 않을 경우 사준다.
            if(d[i] + temp <= budget){
                temp = d[i] + temp;
                answer++;
            }

        return answer;
    }
}