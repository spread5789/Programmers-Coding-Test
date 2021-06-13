import java.util.*;

class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int[] temp = new int[str.length];
        
        for(int i=0;i<str.length;i++)
            temp[i] = Integer.parseInt(str[i]);
        
        Arrays.sort(temp);
        String answer = temp[0] + " " + temp[temp.length-1];
        
        return answer;
    }
}