class Solution {
    public double solution(int[] arr) {
		
		/*
			return (int) Arrays.stream(array).average().orElse(0);
		*/
		
        double answer = 0;
        
        for(int i=0;i<arr.length;i++){
            answer+=arr[i];
        }
        
        return answer/=arr.length;
        
    }
}