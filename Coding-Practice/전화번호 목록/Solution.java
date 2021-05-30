import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for(int i=0;i<phone_book.length-1;i++){
            String temp = phone_book[i];
            if(temp.length() > phone_book[i+1].length())
                continue;
            else if(temp.equals(phone_book[i+1].substring(0,temp.length())))
                return false;
        }
        
        return answer;
    }
}