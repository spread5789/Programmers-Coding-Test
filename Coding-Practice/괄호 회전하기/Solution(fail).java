class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0;i<s.length();i++){
            s = s.substring(1) + s.substring(0,1);
            if(check(s)) answer++;
        }
        
        return answer;
    }
    
    private boolean check(String s){
        int big=0, mid=0, small=0;
        char[] str = s.toCharArray();
        for(char c : str){
            if(c == '[') big++;
            else if(c == '{') mid++;
            else if(c == '(') small++;
            else if(c == ']') big--;
            else if(c == '}') mid--;
            else if(c == ')') small--;
            
            if(big < 0 || mid < 0 || small < 0) return false;
        }
        
        if(big == 0 && mid == 0 && small == 0) return true;
        
        return false;
    }
}