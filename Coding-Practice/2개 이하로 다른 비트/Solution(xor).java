class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0;i<numbers.length;i++)
            answer[i] = diffCount(numbers[i]);
        
        return answer;
    }
    
    public long diffCount(long a){
        int count;
        long answer;
        
        for(long i = 1;;i++){
            count = 0;
            String temp = Long.toBinaryString(a^(a+i));
            
            for(int j=0;j<temp.length();j++){
                if(temp.charAt(j)=='1') count++;
            }
            
            if(count<=2) {
                answer = a+i;
                break;
            }
        }
        
        return answer;
    }
}