import java.util.*;

class Solution {
    public long solution(long n) {
        String num = n + "";
        String[] temp = num.split("");
        Arrays.sort(temp);
        long answer = 0;
        
        for(int i=0;i<temp.length;i++){
            answer +=  Long.parseLong(temp[i]) * Math.pow(10,i);
        }
        
        return answer;
    }
}