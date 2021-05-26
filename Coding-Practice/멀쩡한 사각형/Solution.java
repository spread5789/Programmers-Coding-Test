class Solution {
    public long solution(int width, int height) {
        // w 와 h 는 1억 이하의 자연수!!
        long w = width;
        long h = height;
        
        // 최대 공약수 구하기
        long gcd = gcd(w,h);
        
        // 전체 사각형 수 - 정사각형을 만들 수 없는 칸
        return w*h-((w/gcd + h/gcd)-1)*gcd;
    }
    
    public long gcd(long num1, long num2){
        if(num1%num2 == 0){
            return num2;
        }
        
        return gcd(num2,num1%num2);
    }
}