class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        // 제일 첫번째 숫자의 부호때문에 2개를 사용.. 한개로 줄이는 방법을 잘 모르겠다
        // 문제의 예시에서 첫번째. 두번째 줄 맨 앞 -1, +1 을 생각하면 된다.
        // target 과 일치하는 결과가 나온 경우, answer 에 1씩 쌓아준다.
        answer += getDFS(numbers, numbers[0], 1, target);
        answer += getDFS(numbers, -numbers[0], 1, target);
        return answer;
    }
    
    public int getDFS(int[] numbers, int sum, int depth, int target){
        // 모두 탐색했을 경우
        if(depth >= numbers.length){
            // 합이 target 과 일치한다면 1을 반환한다.
            if(sum == target){
                return 1;
            }
            // 합이 target 과 일치하지 않으면 0 을 반환해서 answer에 더해지지 않는다.
            return 0;
        }
        // 재귀 중 현재 합계를 보관하기 위해 temp 변수 생성
        int temp = 0;
        temp += getDFS(numbers, sum + numbers[depth], depth+1, target);
        temp += getDFS(numbers, sum - numbers[depth], depth+1, target);
        return temp;
    }
}