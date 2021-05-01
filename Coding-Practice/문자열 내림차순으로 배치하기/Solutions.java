import java.util.*;

class Solution {
    public String solution(String s) {
        // 문자열을 한 글자씩 배열에 담음
        String[] temp = s.split("");
        
        // 해당 배열을 내림차순으로 정렬
        Arrays.sort(temp,Collections.reverseOrder());
        
        // .join(각 배열사이에 추가할 문자열,합칠 배열)
        return new String(String.join("",temp));
    }
}