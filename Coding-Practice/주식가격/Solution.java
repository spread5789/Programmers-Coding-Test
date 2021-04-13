class Solution {
    public int[] solution(int[] prices) {

        // 주가가 언제까지 떨어지지 않는지 저장하는 변수 count
        int count=0;

        // prices 의 값(주식가)들을 비교해서, 처음 떨어지는 부분을 찾는다.
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){

                // 하한가 부분을 찾으면서, 한번 탐색할 때 마다
                // 조건문과는 관계없이 일수를 더해야하기때문에 count++ 해준다.
                count++;

                // 낮아지는 주식가를 찾았다면 반복문을 탈출한다.
                if(prices[i]>prices[j]) break;
            }

            // 저장해두었던 일수를 탐색했던 원소의 자리에 바꿔놓는다.
            // 주식가 배열은 그대로 두고 temp 배열에 따로 저장해둬야하는 편이 옳은 방법이라고 생각한다.
            // (본인의 변수 줄이는 습관이 여기서..)
            prices[i] = count;

            // 다음 주식가를 탐색하기 전, 저장해 둔 일수를 0으로 초기화한다.
            count = 0;
        }

        return prices;
    }
}