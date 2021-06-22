class Solution {
    public int solution(int n) {
        int count = 0;
        String num = Integer.toBinaryString(n);
        
        for(int i=0;i<num.length();i++)
            if(num.charAt(i)=='1') count++;
        
        while(true){
            int count2 = 0;
            num = Integer.toBinaryString(++n);
            
            for(int i=0;i<num.length();i++)
                if(num.charAt(i)=='1') count2++;
            
            if(count==count2) break;
        }
        
        return Integer.parseInt(num, 2);
    }
}