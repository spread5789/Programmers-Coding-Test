/*
class Solution {
    public long solution(long n) {
        
        for(long i=1;i<=Math.sqrt(n);i++){
            if(Math.pow(i,2)==n)
                return (long)Math.pow(i+1,2);
        }
        return -1;
    }
}
*/

class Solution {
    public long solution(long n) {
        if(Math.pow((int)Math.sqrt(n),2)==n)
            return (long)Math.pow(Math.sqrt(n)+1,2);
        
        return -1;
    }
}