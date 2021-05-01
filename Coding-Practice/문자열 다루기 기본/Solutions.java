class Solution {
    public boolean solution(String s) {
        // 문자열의 길이가 4 혹은 6이 아니면 false
        if(s.length() != 6 && s.length() != 4)
            return false;
        
		// 48(0) 보다 작거나, 57(9) 보다 크다면 숫자가 아니므로 false;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)<48 || s.charAt(i)>57)
                return false;
        
        return true;
    }
}