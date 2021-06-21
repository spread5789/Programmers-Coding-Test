class Solution
{
    public int solution(int [][]board)
    {
        // 우측 하단 값들에 지금까지 만들 수 있는 정사각형의 최대 크기를 축적해 나아갈 것이다.
        // max = 현재 검사하고있는 값[i][j] 기준으로 상,좌,상좌(대각선) 을 검사해서 정사각형이 만들어 질 경우 +1 을 해준다.
        int max = 0;
        int[][] temp = new int[board.length+1][board[0].length+1];
        
        // 만약 board 크기가 1,1 일 경우 상,좌,상좌 를 검사할 시 인덱스 범위를 벗어나므로 한칸 씩 확장해준다.
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                temp[i+1][j+1] = board[i][j];
        
        // 기준 좌표가 1일때, 상, 좌, 상좌 의 값들도 모두 1 일 경우, 정사각형을 만들 수 있다.
        // 그럴때 한 변의 길이가 2가 되는데, 이 값을 기준 좌표에 저장해둔다.
        // 만약 상,좌,상좌 의 값이 2 이상일 경우는,
        // 정사각형을 만들 수 있다는 보장이 되므로 3.. 이런 식으로 만들 수 있는 정사각형의 크기를 축적해나간다.
        for(int i=1;i<temp.length;i++)
            for(int j=1;j<temp[0].length;j++){
                if(temp[i][j] >= 1){
                    int left = temp[i][j-1];
                    int up = temp[i-1][j];
                    int left_up = temp[i-1][j-1];
                    
                    int min = Math.min(left,Math.min(up,left_up));
                    temp[i][j] = min+1;
                    
                    max = Math.max(max, min+1);
                }
            }
        
        // 정사각형의 크기를 리턴해주기 위해 반지름의 제곱을 곱해준다.
        return max*max;
    }
}