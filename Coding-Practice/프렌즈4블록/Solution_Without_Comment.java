class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] bo = new char[m][n];
        for (int i = 0; i < m; i++)
            bo[i] = board[i].toCharArray();

        while (true) {
            boolean isPossible = false;

            char[][] temp = new char[m][n];
            for (int i = 0; i < m; i++)
                temp[i] = bo[i].clone();

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
			
            if (isPossible==false) break;
            
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (bo[i][j] != temp[i][j])
                        answer++;

            for (int i = 0; i < n; i++) {
                int blank = m - 1;

                while (true) {
                    while (blank > -1 && temp[blank][i] != '*')
                        blank--;
                    int block = blank;
                    while (block > -1 && temp[block][i] == '*')
                        block--;
                    if (block < 0)
                        break;

                    temp[blank][i] = temp[block][i];
                    temp[block][i] = '*';
                }
            }
            bo = temp;
        }
        return answer;
    }
}