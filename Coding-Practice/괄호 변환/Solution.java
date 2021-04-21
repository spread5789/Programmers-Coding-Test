class Solution {
    public String solution(String w) {
        return splitString(w);

    }

    /**
     *
     * String u = 처음으로 발견되는 균형잡힌 괄호 문자열
     * String v = u를 제외한 나머지부분
     * StringBuilder temp2 =
     */

    public String splitString(String w){
        String u="";
        String v="";
        String[] temp = w.split("");
        StringBuilder temp2 = new StringBuilder();

        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(w.equals("")) return "";

        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
        // 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        for(int i=0;i<temp.length;i++){
            int count = 0;
            if(temp[i].equals("(")) count++;
            else if(temp[i].equals(")")) count--;

            if(count==0){
                u = w.substring(0,i+1);
                v = w.substring(i+1);
                break;
            }
        }
        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        if(isCorrect(u)) return u += splitString(v);    // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.

        // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        else if(!isCorrect(u)){

            // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            temp2.append("(");

            // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            temp2.append(splitString(v));

            // 4-3. ')'를 다시 붙입니다.
            temp2.append(")");

            // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            for(int j=1;j<u.length()-1;j++){
                if((String.valueOf(u.charAt(j)).equals("("))) temp2.append(")");
                else if((String.valueOf(u.charAt(j)).equals(")"))) temp2.append("(");
            }
        }
        //4-5. 생성된 문자열을 반환합니다.
        return temp2.toString();
    }

    // 올바른 괄호 문자열 체크
    public boolean isCorrect(String u){
        int count = 0;
        for(int i=0;i<u.length();i++){
            if(String.valueOf(u.charAt(i)).equals("(")) count++;
            else if(String.valueOf(u.charAt(i)).equals(")")) count--;

            if(count<0) return false;
        }
        return true;
    }

}