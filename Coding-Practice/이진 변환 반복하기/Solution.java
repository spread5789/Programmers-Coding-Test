class Solution {
    public int[] solution(String s) {
        int zero=0;
        int count=0;
        
        while(!s.equals("1")){
            for(int i=0;i<s.length();i++)
                if(s.charAt(i)=='0') zero++;
            s = Integer.toBinaryString(s.replaceAll("0","").length());
            count++;
        }
        
        return new int[]{count,zero};
    }
}