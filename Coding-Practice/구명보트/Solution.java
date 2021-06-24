// 가장 무게가 높은 사람과, 낮은 사람을 선택한다.
// 제한을 넘는다면, 무게가 높은 사람을 혼자 태운 후, 다음으로 무게가 높은 사람으로 재선택한다.
// 재선택 된 사람과 가장 낮은 사람을 비교 후, 제한을 넘는다면 역시 무게가 높은 사람을 혼자 태운다.

// 제한을 넘지 않는다면, 두 사람을 모두 태운 후 두번째로 무게가 낮은 사람을 선택한다.

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int index=0;
        int answer=0;
        Arrays.sort(people);
        
        for(int i=people.length-1;i>=index;i--)
            if(people[i]+people[index] <= limit){
                answer++;
                index++;
            }else{
                answer++;
            }
        
        return answer;
    }
}