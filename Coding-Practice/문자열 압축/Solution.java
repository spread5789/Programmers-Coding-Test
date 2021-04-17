class Solution {
    public int solution(String s) {
        
        //문자는 아니지만 손에 익는 단어이므로 문자로 했습니다.. (just 여러개의 문자)
        
        // 입력 문자가 1개일 경우 뺨 때리고 돌려보내기
        if(s.length()==1) return 1;

        // 최소길이를 저장해놓는 변수,
        int min=s.length();

        // String 에 계속 문자를 추가하는 형식이라 Builder를 사용했습니다.
        StringBuilder sb = new StringBuilder();

        // interval = 몇글자씩 나눌지 나타내는 변수입니다.
        for(int interval = 1;interval<=s.length()/2;interval++){
            sb.setLength(0);    // StringBuilder 초기화 (setLength(0) 으로 초기화하면 속도가 더 빠릅니다)
            int count = 1;
            String prev = "";   // 이전문자 저장용
            
            // 바로 아래 2줄은 천천히 시뮬레이션 해보며 이해하기
            for(int i=0;i<s.length()/interval;i++){
                String check = s.substring(i*interval , (i+1)*interval);

                // 문자가 같다면 count 값을 증가한다.
                if(prev.equals(check)){
                    count++;
                    continue;

                // 겹친게 있었고, 지금은 안겹친다면 겹친 횟수 + 겹친 문자 저장
                } else if (count > 1) {
                    sb.append(count + prev);
                    count = 1;

                // 겹친것도 없었으면 저장해놓은 문자를 저장
                } else{
                    sb.append(prev);
                }
                prev = check;   // 저장된 문자를 이전문자로 옮겨줘서 다음문자 탐색하기
            }
            // 다음 비교할 문자가 없지만, 저장되어있는 문자는 처리하지 않았으므로 처리
            if(count > 1){
                sb.append(count + prev);
            }else{
                sb.append(prev);
            }

            // 나누어 떨어지지 않아서 탐색되지 않은 문자들 처리
            if(s.length()%interval != 0) sb.append(s.substring(s.length() - s.length()%interval));
            min = Math.min(min,sb.length());    // 최소길이를 요구하는 문제이므로 최소길이를 저장해놓습니다.
        }

        return min;
    }
}
