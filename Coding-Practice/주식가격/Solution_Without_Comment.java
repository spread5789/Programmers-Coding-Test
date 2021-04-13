class Solution {
    public int[] solution(int[] prices) {

        int count=0;

        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                count++;
                if(prices[i]>prices[j]) break;
            }

            prices[i] = count;
            count = 0;
        }
        return prices;

    }
}