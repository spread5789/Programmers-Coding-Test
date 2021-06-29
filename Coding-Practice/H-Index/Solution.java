import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        for(int i = citations.length-1; i >= 0; i--){
            int few = Math.min(citations[i], citations.length - i);
            if(max < few) max = few;
            else break;
        }
        return max;
    }
}