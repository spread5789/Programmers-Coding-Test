class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n,m);
        answer[1] = (n*m)/answer[0];
        
        return answer;
    }
    
    // Euclidean Algorithm
    private int gcd(int a, int b){
        
        // 1번째 방법
        if(a%b==0)
            return b;
        return gcd(b,a%b);
        
        /* 2번째 방법
        while(b!=0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
        */
    }
    
}