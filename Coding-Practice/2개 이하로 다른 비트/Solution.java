class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            StringBuilder sb = new StringBuilder();
            String binary = "00"+Long.toBinaryString(numbers[i]);
            
            if(numbers[i]%2==0){
                sb.append(binary.substring(0,binary.length()-1) + "1");
				//answer[i]=numbers[i]+1;
                //continue;
            }else{
                int index = binary.lastIndexOf("01");
                sb.append(binary.substring(0,index)+"10"+binary.substring(index+2));
            }
            answer[i]=Long.parseLong(sb.toString(),2);
        }
            
        return answer;
    }
}