class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb= new StringBuilder();
        StringBuilder answer=new StringBuilder();
        
        for(int i=0;sb.length() < (m*t)+p;i++){
            switch(n){
                case 2:
                    sb.append(Integer.toBinaryString(i));
                    break;
                case 8:
                    sb.append(Integer.toOctalString(i));
                    break;
                case 16:
                    sb.append(Integer.toHexString(i));
                    break;
                case 10:
                    sb.append(Integer.toString(i));
                    break;
            }
        }
        
        
        for(int i=p-1;answer.length()<t;i+=m)
            answer.append(sb.charAt(i));
        
        return answer.toString().toUpperCase();
    }
        

}