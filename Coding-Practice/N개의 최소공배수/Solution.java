class Solution {
    public int solution(int[] arr) {
        int a=arr[0], b;
        
		(순서대로 최소공배수를 구한다)
        for(int i=0;i<arr.length-1;i++){
            b = arr[i+1];
            a = lcm(a,b);
        }
        
        return a;
    }
    // 유클리드 (나머지가 b, 나눈 값이 a 가 되며, 나머지가 0일때 나눈 값이 최대공약수)
    private int gcd(int a, int b){
        if(a%b==0)
            return b;
        
        return gcd(b,a%b);
    }
    
	// 두 수의 최소 공배수 = a*b / gcd;
    private int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
}