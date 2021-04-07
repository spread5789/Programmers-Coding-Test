import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {

        // participant 배열과 completion 배열을 비교하고 없는 값을 return 하라
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0;i < completion.length;i++)
            if(!participant[i].equals(completion[i]))
            {
                answer = participant[i];
                break;
            }

        if(answer.equals(""))
            return answer = participant[participant.length-1];

        return answer;
    }
}