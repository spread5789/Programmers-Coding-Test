class Solution {
    public int solution(String s) {
        // 입력 문자가 1개일 경우 뺨 때리고 돌려보내기
        if(s.length()==1) return 1;

        // 최소길이를 저장해놓는 변수,
        int min=s.length();

        StringBuilder sb = new StringBuilder();

        for(int interval = 1;interval<=s.length()/2;interval++){
            sb.setLength(0);    // StringBuilder 초기화
            int count = 1;
            String prev = "";   // 이전문자 저장용
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
                prev = check;
            }
            // 다음 비교할 문자가 없지만, 저장되어있는 문자는 처리하지 않았으므로 처리
            if(count > 1){
                sb.append(count + prev);
            }else{
                sb.append(prev);
            }

            // 남아있는 문자들 처리
            if(s.length()%interval != 0) sb.append(s.substring(s.length() - s.length()%interval));
            min = Math.min(min,sb.length());
        }

        return min;
    }
}