class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        // a 가 더 클 경우, 스왑
        if(a>b){
            int temp = a;
            a = b;
            b = temp;
        }
        
        // 사이 값 더해주기
        for(int i=a;i<=b;i++)
            answer+=i;
        
        return answer;
    }
}