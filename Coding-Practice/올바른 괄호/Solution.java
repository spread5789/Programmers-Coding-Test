import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(char c : str){
            if(stack.empty() || c=='(')
                stack.push(c);
            else
                if(stack.peek()=='(')
                    stack.pop();
        }
        
        if(stack.empty())
            return true;
        
        return false;
    }
}