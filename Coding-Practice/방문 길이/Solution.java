class Solution {
    int answer;
    boolean[][][][] visited = new boolean[11][11][11][11];
    int x, y, next_x, next_y;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    /**
     * x,y = 현재 좌표
     * next_x, next_y = 이동 할 좌표
     * dx, dy = 방향
     */
    public int solution(String dirs) {
        answer = 0;
        x = 5;
        y = 5;
        next_x = 5;
        next_y = 5;
        for (char c : dirs.toCharArray()) {
            x = next_x;
            y = next_y;
            
            switch(c){
                case 'U' :
                    next_x = x + dx[0];
                    next_y = y + dy[0];
                    break;
                case 'D' :
                    next_x = x + dx[1];
                    next_y = y + dy[1];
                    break;
                case 'L' :
                    next_x = x + dx[2];
                    next_y = y + dy[2];
                    break;
                case 'R' :
                    next_x = x + dx[3];
                    next_y = y + dy[3];
                    break;
            }

            // 맵을 벗어나면 제자리로 복귀
            if (next_x < 0 || next_x > 10 || next_y < 0 || next_y > 10) {
                next_x = x;
                next_y = y;
                continue;
            }
            //방문한 길인지 확인
            if (!visited[x][y][next_x][next_y]) {
                visited[x][y][next_x][next_y] = true;
                visited[next_x][next_y][x][y] = true;
                answer++;
            }
        }
        
        return answer;
    }
}