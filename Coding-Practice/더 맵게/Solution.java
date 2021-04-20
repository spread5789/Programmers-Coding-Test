import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 접근 방식 생각 //
        // 우선순위 큐를 사용해서, 순서대로 poll 해주면 최소값이 2개가 나올 것
        // 2개 값을 문제 요구사항처럼 더해준 후 다시 넣어서
        // k 이상일때 리턴해주면 될려나

        int count = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();

        // 큐에 담아주기
        for(int i : scoville)
            que.add(i);

        // 2번 poll 하기때문에, 그 만큼의 크기가 있는지 확인(size > 1) 해줘야 하고,
        // 최소값이 K만큼 되었다면 그만 카운트해도 된다.
        while(que.size() > 1 && que.peek() <= K){
            int one = que.poll();
            int temp = one + que.poll()*2;
            que.add(temp);
            count++;
        }

        // 더 이상 합칠 음식이 없어 K 이상을 만들지 못할경우 -1을 리턴해준다. (문제 요구사항)
        if(que.peek() < K) return -1;

        return count;
    }
}