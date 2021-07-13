class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        // char 형식의 2차원배열로 옮겨줌
        char[][] bo = new char[m][n];
        for (int i = 0; i < m; i++)
            bo[i] = board[i].toCharArray();

        // 시작 -----------------------------------------------------------

        while (true) {
            // 제거할 수 있는 블럭이 있는지 확인
            boolean isPossible = false;

            // 비교하기 위한 임시 테이블을 만들어줌.
            // 이유 : 원본 테이블에서 2*2 블럭을 제거한다면 문제에서 라이언이 한번 겹치는 부분이 제거되지 않는다.
            // 따라서, 원본테이블과 비교하면서 제거할 수 있는 부분을 체크할 수 있는 테이블이 추가로 필요하다.
            char[][] temp = new char[m][n];
            for (int i = 0; i < m; i++)
                temp[i] = bo[i].clone();

            // 블럭이 2*2 로 뭉쳐서 없앨 수 있다면, 임시 테이블에 *로 체크해둠.
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (bo[i][j] == bo[i+1][j]
                            && bo[i][j] == bo[i][j+1]
                            && bo[i][j] == bo[i+1][j+1]
                            && bo[i][j] != '*') {
                        temp[i][j] = temp[i+1][j] = temp[i][j + 1] = temp[i + 1][j + 1] = '*';
                        isPossible = true;
                    }
                }
            }
            // 변경할 블럭이 없다면 탈출.
            if (isPossible==false) break;
            
            // 임시 테이블과 내용이 다른 부분들은 뭉쳐서 제거할 수 있는 부분이므로, 다른 부분들의 개수를 더해줌.
            // * 의 개수를 세는 방법을 이용할 경우, 비교 전 테이블의 * 개수에서 빼주거나 다른 방법을 사용하지 않는 이상 공백의 개수를 세는 것이므로 주의해야 할 듯
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (bo[i][j] != temp[i][j])
                        answer++;

            // 이제 빈 공간을 제거합시다. [각 줄마다 확인]
            for (int i = 0; i < n; i++) {
                // 제일 윗 줄은 공백이어도 상관없으니 -1 (m은 전체 테이블의 높이)
                int blank = m - 1;

                // 블럭이 내려와서 빈 공간을 채우는 부분
                while (true) {
                    // '밑에서부터' 위에 있는 블럭 유무와 '상관없이' 공백(*)이 있는 부분을 찾음.
                    while (blank > -1 && temp[blank][i] != '*')
                        blank--;
                    // 이 시점에서는 밑에서부터 공백이 처음으로 나타나는 높이 위치를 blank가 가지고있음.

                    // 공백은 찾았고, 이제 공백부터 위에 블럭이 있는지 확인
                    int block = blank;
                    while (block > -1 && temp[block][i] == '*')
                        block--;
                    // 이 시점에서는 공백 위에 있는 블럭의 위치를 block 가 가지고있음.

                    // 위쪽이 모두 공백이라면 탈출 [더 이상 빈 공간이 없음]
                    if (block < 0)
                        break;

                    // 공백 위치에, 공백 위의 블럭을 채워준 후 블럭 자리를 공백으로 바꿔줌.
                    temp[blank][i] = temp[block][i];
                    temp[block][i] = '*';
                }
            }
            // 임시 블럭 테이블을 공백 제거 전 테이블에 넣어서 처리 결과를 '반영' 시켜줌
            bo = temp;

        }

        return answer;
    }

}