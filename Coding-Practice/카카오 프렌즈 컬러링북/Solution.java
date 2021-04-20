class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        // 접근방식 생각..
        // 체크했는지 확인하는 동일한 크기의 2차원배열이 필요할 듯
        // 0인경우 미로처럼 벽이라고 생각
        // 한가지 색을 정하고 이미 체크했는지와 상 하 좌 우 로 같은색일경우에만 카운트 후 영역의 개수와 가장 큰 값 리턴

        int numberOfArea = 0;       // 각 영역의 크기
        int maxSizeOfOneArea = 0;   // 가장 큰 영역의 크기
        int[][] visited = new int[m][n];

        // 1.방문했는지 확인하는 동일한 2차원배열이 필요할 듯
        for(int i=0;i<picture.length;i++)
            for(int j=0;j<picture[i].length;j++)
                visited[i][j] = picture[i][j];

        // 2.방문 시작
        for(int y=0;y<visited.length;y++) {
            for (int x = 0; x < visited[y].length; x++) {
                // 모두 탐색 후 sum이 각 영역크기를 가져온다.
                int sum = check(y, x, visited, visited[y][x]);

                // 문제에서 요구하는것은 각 영역들의 크기가 아니라 몇개의 영역인지
                if (sum > 0) numberOfArea++;

                // 그리고 가장 넓은 영역크기는 몇인지이다.
                if (sum > maxSizeOfOneArea)  maxSizeOfOneArea = sum;

            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    // 3. 방문하면서 탐색 시작
    // x,y = x,y 좌표
    // visited = 현재 그림 정보를 가지고있고, 방문했을 경우 해당 색상값을 0으로 변경해서 방문했다는 것을 표시할것임.
    // color = 서로 다른 여러 색상중, 현재 탐색하고있는 색
    public int check(int y,int x,int[][] visited,int color){

        // 모두 탐색했는지 확인
        // x,y 가 해당범위에서 벗어났는지, 이미 방문한곳인지, 같은색상인지 체크
        if(x < 0 || y < 0 || x >= visited[y].length || y >= visited.length || visited[y][x] == 0 || visited[y][x] != color)
            return 0;

        // 위 조건이 모두 아니면 탐색해야하는곳이므로 방문한다. 이때 방문했음을 체크해주기 위해 값을 0으로 대체
        visited[y][x] = 0;

        // 각 상,하,좌,우 위치들을 모두 탐색하면서, 같은 색의 영역을 찾았으니 영역 크기값을 +1 해줌
        return 1+check(y-1,x,visited,color)    // 상
                +check(y+1,x,visited,color)    // 하
                +check(y,x-1,visited,color)    // 좌
                +check(y,x+1,visited,color);   // 우

    }

}
