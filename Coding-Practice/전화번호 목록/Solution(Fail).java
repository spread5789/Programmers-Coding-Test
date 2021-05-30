import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for(int i=0;i<phone_book.length-1;i++){
            for(int j=i+1;j<phone_book.length;j++){
                String temp = phone_book[i];
                if(temp.length() > phone_book[j].length()) continue;
                else if(temp.equals(phone_book[j].substring(0,temp.length())))
                    return false;
            }
        }
        
        return answer;
    }
}