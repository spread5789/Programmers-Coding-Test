import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> bucket = new ArrayList<Integer>();

        // 인형 뽑기
        for(int i=0;i<moves.length;i++){    // 인형 뽑는 횟수만큼
            for(int j=0;j<board.length;j++){    // 보드의 크기만큼
                if(board[j][moves[i]-1] != 0){    // 인형을 찾았다면
                    bucket.add(board[j][moves[i]-1]);   // 바구니에 담은 후
                    board[j][moves[i]-1]=0;             // 뽑은 인형 자리를 비워주자
                    break;
                }
            }
        }

        // 같은 인형 터뜨리기
        for(int k=0;k<bucket.size();k++){   // 바구니에 담긴 인형 수만큼
           if(k != (bucket.size()-1)){      // 바구니를 다 돌았을 경우 탈출
               if(bucket.get(k)==bucket.get(k+1)){  // k번째 인형이 k+1 인형과 같을 경우
                   bucket.remove(k);        // 두 인형 모두를 제거한다
                   bucket.remove(k);
                   answer+=2;
                   k=-1;                    // 로직을 재시작 한다.
                }
            }
       }

        return answer;
    }
}
