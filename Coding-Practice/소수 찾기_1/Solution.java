class Solution {
    public int solution(int n) {
        int count = 0;
        
        for(int i=1;i<=n;i++)
            if(isPrime(i))
                count++;
        
        return count;
    }
    
    // 소수 판별 메소드
    private boolean isPrime(int num){
        if(num==1)
            return false;
        
        for(int i=2;i<=Math.sqrt(num);i++)
            if(num%i == 0)
                return false;
            
        return true;
        
    }
}