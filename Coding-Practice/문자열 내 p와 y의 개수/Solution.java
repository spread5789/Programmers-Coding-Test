class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int count = 0;
		
		// 비교를 위해 모두 소문자로 변경
        s = s.toLowerCase(); 
        
		// 각 문자가 p,y인지 찾는다
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='p')
                count++;
            else if(s.charAt(i)=='y')
                count--;
        }
        
		// 수가 같으면 true, 다르면 false
        if(count==0) answer = true;
        else answer = false;


        return answer;
    }
}