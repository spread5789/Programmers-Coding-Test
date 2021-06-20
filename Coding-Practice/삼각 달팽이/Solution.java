class Solution {
    public int[] solution(int n) {
        int x=0, y=-1, num=0;
        int[][] temp = new int[n][n];
        
        // 삼각 달팽이 만들기
        // i = 반복 회수, j = 한 변(?)의 길이
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i % 3 == 0) y++;         // 아래로
                else if(i % 3 == 1) x++;    // 오른쪽으로
                else if(i % 3 == 2){        // 위로
                    x--;
                    y--;
                }
                temp[y][x] = ++num;
            }
        }
        
        int a=0;
        int[] answer = new int[num];
        
        // 달팽이 -> 1차원 배열로 옮기기
        // 아래에 조건문을 넣어주지 않으면 아래처럼 값이 들어간다.
        // [1, 0, 0, 0, 0, 0, 2, 15, 0, 0, +11 more]      <- 잘못된 결과
        // [1, 2, 15, 3, 16, 14, 4, 17, 21, 13, +11 more] <- 원하는 결과
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(temp[i][j]==0) break;    
                answer[a++] = temp[i][j];
            }
        }
        
        return answer;
        
    }
}