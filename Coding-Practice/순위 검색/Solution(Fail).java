class Solution {
    int sum;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[info.length];

        for(int z=0;z<info.length;z++){
            // 지원자 정보 (String[][] cand)
            String[][] cand = new String[info.length][5];
            for(int i=0;i<info.length;i++){
                cand[i] = info[i].split(" ");
            }

            // 조건 정보 (String[] cond)
            String[] cond = query[z].replaceAll("and ","").split(" ");

            sum = 0;
            // 각 조건 별 지원자 체크
            for(int i=0;i<cand.length;i++){
                for(int j=0;j<cand[i].length;j++){
                    if(j==4){
                        int a = Integer.parseInt(cand[i][4]);
                        int b = Integer.parseInt(cond[4]);
                        if(a >= b){
                            sum++;
                            break;
                        }
                    }

                    else if(!cond[j].equals(cand[i][j]) && !cond[j].equals("-")){
                        break;
                    }
                }
            }

            answer[z] = sum;

        }

        return answer;
    }
}