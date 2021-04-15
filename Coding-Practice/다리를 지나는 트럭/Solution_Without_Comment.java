import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int time = 0;
        int next = 0;
        int kg = 0;

        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<bridge_length;i++)
            que.add(0);

        while(next < truck_weights.length)
        {
            time++;
            kg -= que.poll();

            if(kg + truck_weights[next] <= weight && next < truck_weights.length){
                kg += truck_weights[next];
                que.add(truck_weights[next++]);
            } else que.add(0);

        }
        return time + bridge_length;
    }
}