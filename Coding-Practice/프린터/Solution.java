import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        // 가장 처음에 출력될 경우 1번째로 출력되는것이므로 1로 초기화해준다.
        int answer = 1;

        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<priorities.length;i++)
            que.add(priorities[i]);

        // 현재 que 에는 우선순위별로 인쇄되기위해 줄을 서있다.

        while(!que.isEmpty()){
            for(int i=0;i<priorities.length;i++){

                // i가 탐색하고있는 인쇄물이 가장 높은 우선순위와 같다면
                if(priorities[i]==que.peek()){

                    // i가 탐색하고있는 인쇄물이 내가 원하는 인쇄물인가
                    if(location==i) return answer;

                    // 우선순위는 높지만 내가 원하는 인쇄물이 아니라면
                    // 해당 인쇄물을 출력시켜준 후 계속 탐색한다(당연히 순서는 밀리기에 answer 증가)
                    que.poll();
                    answer++;
                }
            }
        }

        return answer;
    }
}