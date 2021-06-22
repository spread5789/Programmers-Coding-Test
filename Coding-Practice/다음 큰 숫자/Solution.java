class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        
        while(true){
            int count2 = Integer.bitCount(++n);
            if(count==count2) break;
        }
        
        return n;
    }
}