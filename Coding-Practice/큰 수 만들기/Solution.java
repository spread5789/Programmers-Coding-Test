class Solution {
    public String solution(String number, int k) {
        int start = 0;
        StringBuilder str = new StringBuilder();

        // number 의 길이에서 k를 뺀 만큼 숫자를 뽑는다.
        for(int i=0;i<number.length()-k;i++){
            char MAX = '0';

            // i+k = 만약 4개를 뽑아야 할 경우
            // 뽑아야하는 수 중에서 뒤 3자리는 뽑을 수 없다.
            // 즉 뽑을 수 있는 범위 =  이미 뽑은 수의 인덱스(start)부터 추가로 뽑아야 하는 수(i+k) 까지.

            for(int j=start;j<=i+k;j++){
                if(MAX < number.charAt(j)){
                    MAX = number.charAt(j);
                    start = j+1; // 방금 뽑은 수 다음 인덱스부터 제일 큰 수를 찾아야함.
                }
            }
            str.append(MAX);
        }

        return str.toString();
    }
}