import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        // 입출력 예 2 와 같은 처리를 위해 정렬을 미리 해준다.
        Arrays.sort(strings);
        
        // 문자열만 비교해서 순서를 바꿔준다.
        for(int i=0;i<strings.length;i++)
            for(int j=0;j<strings.length-i-1;j++){
                if(strings[j].charAt(n) > strings[j+1].charAt(n)){
                    String temp = strings[j];
                    strings[j] = strings[j+1];
                    strings[j+1] = temp;
                }
            }
        
        return strings;
    }
}