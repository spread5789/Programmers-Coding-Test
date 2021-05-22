class Solution {
    public int solution(int a) {
        int count = 0;
        long num = a;
        
        while(true){
            if(num==1)
                break;
            
            else if(count==500)
                return -1;
            
            num = num%2==0 ? num/2 : num*3+1;
            count++;
        }
        
        return count;
    }
}