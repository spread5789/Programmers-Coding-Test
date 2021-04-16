class Solution {
    public String solution(int n) {

        String answer = "";
        // n 이 더이상 나누어지지 않을때까지 계속 나눈다.
        while(n>0){

            // 일반적인 3진수와의 차이점은 0 대신 4가 들어간다는 것
            if(n%3==0){
                answer = "4"+answer;

                // 그리고 자릿수를 하나 줄여줘야하기때문에 1을 빼준다..
                // 이 부분은 말로 설명하기 힘들다
                n--;
            }
            else if(n%3==1) answer = 1 + answer;
            else answer = 2 + answer;

            // 나머지를 한번씩 구하고 뒤에 붙여줬으니, 몫을 나눠준다
            n/=3;
        }
        return answer;
    }
}