import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {

        int answer = 0;

        Stack<Integer> stack = new Stack<Integer>();

        // 인형뽑기를 moves 크기만큼 실행
        for(int move : moves)
            // 인형이 들어있는지 확인 후 있으면 뽑는다.
            for(int y=0;y<board[move-1].length;y++)
                if(board[y][move-1] != 0){                  // 뽑은것이 인형이라면
                    if(stack.isEmpty())                     // 바구니가 비어있는지 확인 후
                        stack.push(board[y][(move-1)]);     // 비어있다면 넣고
                    else{
                        if(stack.peek()==board[y][(move-1)])// 비어있지 않다면 전의 인형과 같은지 확인 후
                        {                                   // 같다면 터뜨리고
                            stack.pop();
                            answer += 2;
                        } else                              // 같지 않다면 넣어라
                            stack.push(board[y][(move-1)]);

                    }
                    board[y][(move-1)] = 0;                 // 뽑은 곳을 0 으로 바꿈
                    break;
                }
        return answer;
    }
}