class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        int count = 0;
        int zero = 0;

        // 맞춘 개수와 0의 개수 확인
        for(int i=0;i<lottos.length;i++){
            
            // 0인지 우선 확인
            if(lottos[i] == 0) {
                zero ++;
                continue;
            }
        
            for(int j=0;j<win_nums.length;j++)
                if(lottos[i] == win_nums[j]){
                    count++;
                    break;
                }
        }

        // 맞춘 수도, 0도 하나도 없을때,
        // 처리해주지 않으면 해당 경우의 최저 순위가 7위로 나온다. (7위는 없다)
        if(count==0 && zero == 0) return new int[] {6,6};

        // 알아볼 수 있는 번호로 나온 순위
        int ranking = 7 - count;

        // 알아볼 수 없는 번호가 모두 맞았을경우 최고순위, 다 틀렸으면 최저순위
        int[] answer = {ranking-zero,ranking > 6 ? 6 : ranking};
        return answer;
    }
}