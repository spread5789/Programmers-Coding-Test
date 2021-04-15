import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        // 시간을 나타내는 변수
        int time = 0;

        // 다음 트럭을 알려주는 인덱스
        int next = 0;

        // 현재 다리가 지탱중인 무게
        int kg = 0;

        // 큐 = 다리
        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<bridge_length;i++)
            que.add(0);

        // 다음 트럭이 없을때까지
        while(next < truck_weights.length)
        {
            // 시간을 증가시키고, 다리 공간을 비워주고 무게를 빼줌
            time++;
            kg -= que.poll();

            // 다리가 무게를 견딜 수 있고, 다음트럭이 있을경우
            if(kg + truck_weights[next] <= weight && next < truck_weights.length){
                kg += truck_weights[next];
                que.add(truck_weights[next++]);
            }

            // 트럭이 올라갈 수 없을때는 공간만 넣어줌 (시간을 늘려주기 위함)
            else que.add(0);

        }
        // 마지막 트럭이 올라갔을 경우 건너는 만큼
        // 다리 길이의 시간이 추가로 소요되므로 그 값을 더해줌
        return time + bridge_length;
    }
}