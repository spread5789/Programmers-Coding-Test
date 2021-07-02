import java.util.*;

class Solution {
    public int[] solution(String s) {
        int idx=0;
        ArrayList<String> list = new ArrayList<>();
        String[] temp = s.substring(2,s.length()-2).replaceAll("\\},\\{","-").split("-");
        int[] answer = new int[temp.length];
        
        Arrays.sort(temp,(o1,o2)->o1.length()-o2.length());
        
        for(String a : temp)
                for(String b : a.split(","))
                    if(list.contains(b)) continue;
                    else {
                        list.add(b);
                        answer[idx++] = Integer.parseInt(b);
                    }
        return answer;
    }
}