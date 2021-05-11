class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        /*
            10진수 -> 2진수   String Integer.toBinaryString(1000);
            10진수 -> 8진수   String Integer.toOctalString(9);
            10진수 -> 16진수  String Integer.toHexString(13);
        
            i진수 -> 10진수  int Integer.parseInt("1000",i);
        */
        
        String[] answer = new String[n];
        
        // arr1[i] | arr2[i] 는 비트연산(or) 한 것이다.
        // 즉, 1번 지도, 2번 지도에서 겹치는 부분을 2진수 형태로 or 연산 한 것이다.
        for(int i=0;i<n;i++){
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            // 이 코드가 없을 경우, 010010 같이 첫 자리가 0인 경우 문자형태가 아니기 때문에 생략되어
            // 10010 과 같은 결과가 나타난다.
            // 따라서 n이 5일 경우 %5s,answer[i] 처럼 5글자를 맞춰주어야 한다.
            answer[i] = String.format("%"+n+"s",answer[i]);
            
            // 1을 벽(#) 으로, 0을 길(공백) 으로 변경해준다.
            answer[i] = answer[i].replaceAll("1","#");
            answer[i] = answer[i].replaceAll("0"," ");
        }
        
    
        return answer;
    }
}