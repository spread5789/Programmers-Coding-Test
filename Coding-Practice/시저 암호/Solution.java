class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;is.length();i++){
            char temp = s.charAt(i);

            if('A' = temp && temp = 'Z'){          대문자일때
                if(temp + n  'Z')                   Z 가 넘어가면,
                    temp = (char)(temp + n - 26);    총 알파벳 개수인 26을 빼준다.
                else
                    temp = (char)(temp + n);
            }
            
            else if('a' = temp && temp = 'z'){     소문자일때
                if(temp + n  'z')                   z 가 넘어가면,
                    temp = (char)(temp + n - 26);    총 알파벳 개수인 26을 빼준다.
                else
                    temp = (char)(temp + n);
            }

            sb.append(temp);
        }

        return sb.toString();
    }
}