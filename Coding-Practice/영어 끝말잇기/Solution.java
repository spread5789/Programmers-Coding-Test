import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int count1=1, count2, who=1;
        ArrayList<String> list = new ArrayList<>();
        
        list.add(words[0]);
        for(int i=1;i<words.length;i++){
            count1++;
            count2=(count1/n)+1;
            who++;
            who = (who%n==0)?1:who;
            
            if(list.contains(words[i]) || !words[i-1].substring(words[i-1].length()-1).equals(words[i].substring(0,1)))
                return new int[]{who,count2};
            
            list.add(words[i]);
        }
        return new int[]{0,0};
    }
}