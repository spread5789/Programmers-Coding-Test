class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[][] visited = new int[m][n];

        for(int i=0;i<picture.length;i++)
            for(int j=0;j<picture[i].length;j++)
                visited[i][j] = picture[i][j];

        for(int y=0;y<visited.length;y++) {
            for (int x = 0; x < visited[y].length; x++) {
                int sum = check(y, x, visited, visited[y][x]);
                if (sum > 0) numberOfArea++;
                if (sum > maxSizeOfOneArea)  maxSizeOfOneArea = sum;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int check(int y,int x,int[][] visited,int color){

        if(x < 0 || y < 0 || x >= visited[y].length || y >= visited.length || visited[y][x] == 0 || visited[y][x] != color)
            return 0;

        visited[y][x] = 0;

        return 1+check(y-1,x,visited,color)    // 상
                +check(y+1,x,visited,color)    // 하
                +check(y,x-1,visited,color)    // 좌
                +check(y,x+1,visited,color);   // 우
    }
}