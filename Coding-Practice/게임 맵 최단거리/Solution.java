import java.util.*;

class Solution {
    int xSize,ySize;
	
	// 0부터 3까지 인덱스를 돌리면 현 좌표의 상 하 좌 우 를 탐색할 수 있도록
    int[] xPos = {1,-1,0,0};
    int[] yPos = {0,0,1,-1};
	
	// 방문했는지 체크하기 위함
    boolean visited[][];
    
    public int solution(int[][] maps) {
        xSize = maps[0].length;
        ySize = maps.length;
        visited = new boolean[ySize][xSize];
        
		// 가장 첫 노드로 x,y 가 0,0 인 노드 방문
        return bfs(maps, 0, 0);
    }
    
    private int bfs(int[][] maps, int y, int x){
		// 가장 첫 노드(0,0) 를 방문했음을 체크
        visited[y][x] = true;
        Queue<Node> que = new LinkedList<>();
		// 방문 한 노드를 큐에 넣어줌
        que.add(new Node(x,y,1));
        
        while(!que.isEmpty()){
			// 방문 한 노드를 큐에서 빼줌
            Node node = que.poll();
            
			// 모두 탐색했을 경우 리턴
            if(node.x == xSize-1 && node.y == ySize-1)
                return node.sum;
            
            for(int i=0;i<4;i++){
				// 상 하 좌 우 탐색하기 위해
                int nextX = node.x + xPos[i];
                int nextY = node.y + yPos[i];
                
				// 다음 좌표가 맵 안에 있고 방문하지 않았으며 벽이 아니라면
                if(nextX >=0 && nextY >= 0 && nextX < xSize && nextY < ySize)
                    if(maps[nextY][nextX] == 1 && !visited[nextY][nextX]){
					// 방문 체크 및 큐에 넣어줌.
                        visited[nextY][nextX] = true;
                        que.add(new Node(nextX, nextY, node.sum+1));
                    }
            }
        }
        return -1;
    }
    
	// 각 노드의 정보를 담은 클래스
    public class Node{
        int x;
        int y;
        int sum;
        
        public Node(int x, int y, int sum){
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }
}