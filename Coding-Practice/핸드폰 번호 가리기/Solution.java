class Solution {
    public String solution(String num) {
        int count = num.length()-4;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<count;i++)
            sb.append("*");
        
        return sb.append(num.substring(count)).toString();
    }
}