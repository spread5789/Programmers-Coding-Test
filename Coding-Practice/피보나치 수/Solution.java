class Solution {
    public int solution(int n) {
        int a = 1, b = 1;
        int temp=0;
        int r = 1234567;
        
        if(n==1 || n==2) return 1;
        
        for(int i=0;i<n-2;i++){
            temp = (a%r+b%r)%r;
            a = b;
            b = temp;
        }
        return temp;
    }
}