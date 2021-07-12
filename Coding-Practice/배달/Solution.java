import java.util.*;

class Solution {            
    private static ArrayList<Edge>[] edgeList; // 마을(노드) 리스트
    private static int[] distance; // 1번 마을과 다른 도시간 최단 경로를 저장하는 배열
    
    // 마을 정보 클래스
    // vertex = 각 마을 노드
    // weight = 각 마을까지 걸리는 시간
    private static class Edge implements Comparable<Edge> {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }
    
    // edgeList = 각 노드[마을]을 담아줄 리스트
    // distance = 각 마을까지의 거리 가중치를 저장할 배열
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        edgeList = new ArrayList[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            edgeList[i] = new ArrayList<>();
        }
        // 각 마을들의 거리정보 저장
        for (int i = 0; i < road.length; i++) {
            edgeList[road[i][0]].add(new Edge(road[i][1], road[i][2]));
            edgeList[road[i][1]].add(new Edge(road[i][0], road[i][2]));
        }
        distance[1] = 0; //1번 마을 자신
        //다익스트라
        dijkstra();
        // 1번마을에서 K 이하 비용인 도시 개수 구하기
        for (int cost : distance) {
            if (cost <= K) {
                answer++;
            }
        }
        return answer;
    }
    


    private static void dijkstra() {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(1, 0));
        
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int vertex = edge.vertex;
            int weight = edge.weight;
            
            // 기존 거리가 더 짧다면 거리를 새로 갱신하지 않는다.
            if (distance[vertex] < weight) continue;
            
            for (int i = 0; i < edgeList[vertex].size(); i++) { // 연결 마을 탐색
                int vertex2 = edgeList[vertex].get(i).vertex;
                int weight2 = edgeList[vertex].get(i).weight + weight;
                if (distance[vertex2] > weight2) { // 최단경로
                    distance[vertex2] = weight2;
                    queue.add(new Edge(vertex2, weight2));
                }
            }
        }
    }

}