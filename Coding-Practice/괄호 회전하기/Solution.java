import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0;i<s.length();i++){
            if(isRight(s)) answer++;
            s = s.substring(1) + s.substring(0,1);
        }
        
        return answer;
    }
    
    private boolean isRight(String s){
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(char c : str){
            if(stack.empty()){
                stack.push(c);
                continue;
            }
            
            if(c == '[' || c == '{' || c == '('){
                stack.push(c);
            }
            else if(c == ']' && stack.peek()=='[')
                stack.pop();
            else if(c == '}' && stack.peek()=='{')
                stack.pop();
            else if(c == ')' && stack.peek()=='(')
                stack.pop();
        }
        if(stack.empty()) return true;
        
        return false;
    }
}