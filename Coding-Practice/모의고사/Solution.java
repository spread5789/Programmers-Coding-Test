import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one= {1,2,3,4,5};
        int[] two={2,1,2,3,2,4,2,5};
        int[] thr= {3,3,1,1,2,2,4,4,5,5};
        int[] collect={0,0,0};
        int high=0;
        ArrayList<Integer> answerList = new ArrayList();

        // 학생별 정답수 체크
        for(int i=0;i<answers.length;i++){
            if(answers[i] == one[i%one.length])
                collect[0]++;
            if(answers[i] == two[i%two.length])
                collect[1]++;
            if(answers[i] == thr[i%thr.length])
                collect[2]++;
        }

        // 최고점수 확인
        for(int i=0;i<collect.length;i++)
            if(high<collect[i])
                high = collect[i];

        // 최고점수인 학생 추출
        for(int i=0;i<collect.length;i++)
            if(high==collect[i]) {
                if (i == 0)
                    answerList.add(1);
                if (i == 1)
                    answerList.add(2);
                if (i == 2)
                    answerList.add(3);
            }

        // ArrayList -> Array 로 변환
        int[] answer = new int[answerList.size()];
        for(int i=0;i<answerList.size();i++)
            answer[i] = answerList.get(i);

        return answer;
    }
}