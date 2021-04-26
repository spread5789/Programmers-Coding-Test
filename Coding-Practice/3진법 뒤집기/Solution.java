class Solution {
    public int solution(int n) {
        String str = "";

        // 3진법 변환 (뒤집으면서 넣기)
        while(n>0){
            str = str + n%3;
            n /= 3;
        }

        // 10진법 변환
        int answer = Integer.parseInt(str,3);

        return answer;
    }
}