class Solution {
    public String solution(String s) {
		// 공백 문자인지 체크하는 변수 (첫 글자는 대문자여야 하므로 기본값은 true)
        boolean space = true;
        StringBuilder sb = new StringBuilder();
        
		// 모두 소문자로 변경해준다.
        s = s.toLowerCase();
        
        for(int i=0;i<s.length();i++){
			// 공백이 올 경우 다음 문자를 대문자로 변경하기 위해 space = true 를 주고, sb에 공백을 추가해준다.
            if(s.charAt(i)==' '){
                space = true;
                sb.append(s.charAt(i));
                continue;
            }
            // 소문자가 왔을 경우, 공백이 왔었다면 대문자로 변경(-32), 아니라면 그냥 추가해준다.
            if(s.charAt(i) >= 'a' && s.charAt(i)<='z'){
                if(space == true){
                    space = false;
                    sb.append((char)(s.charAt(i)-32));
                }
                else
                    sb.append(s.charAt(i));
            }
			// 공백이든 아니든 소문자가 아닐경우 그냥 추가해준 후 공백도 무효처리 해준다.
            else{
                space = false;
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}