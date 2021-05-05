class Solution {
    public int solution(int n) {
        int sum = 0;
        
		/**
        for(int i=1;i<=n;i++){
            if(n%i==0) sum+=i;
        }
        
        return sum;
		**/
		
		// 더 좋은 방법
		for(int i=1;i<=n/2;i++)
			if(n%i==0) sum+=i;
			
		return sum+n;
    }
}