import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> que = new Stack();

        for(int i=0;i<s.length();i++){
            if(que.empty()){
                que.push(s.charAt(i));
            }
            else if(que.peek().equals(s.charAt(i))){
                que.pop();
            }
            else{
                que.push(s.charAt(i));
            }
        }
        if(que.empty()) return 1;
        return 0;
    }
}