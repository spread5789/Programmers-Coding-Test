import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // participant 배열과 completion 배열을 비교하고 없는 값을 return 하라

        ArrayList<String> part = new ArrayList<>(Arrays.asList(participant));

        for(int i=0;i<completion.length;i++)
            part.remove(completion[i]);

        return part.get(0);
    }
}
