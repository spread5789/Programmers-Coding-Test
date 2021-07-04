import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int who=1, count=1, order;
        ArrayList<String> list = new ArrayList<>();
        
        if(words.length==1) return new int[]{0,0};
        
        list.add(words[0]);
        for(int i=1;i<words.length;i++){
            count++;
            order=(n%3==0)?(count/n):(count/n)+1;
            who = (count%n==0)?n:(count%n);
            
            if(list.contains(words[i]) || !words[i-1].substring(words[i-1].length()-1).equals(words[i].substring(0,1)))
                return new int[]{who,order};
            
            list.add(words[i]);
        }
        return new int[]{0,0};
    }
}