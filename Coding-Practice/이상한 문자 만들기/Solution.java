class Solution {
    public String solution(String s) {

		// 문자열을 집어넣을 StringBuilder
        StringBuilder sb = new StringBuilder("");

		// 한 글자씩 뽑는데, 그 한 글자를 저장해놓을 변수
        char temp;
		
		// 전체 문장 중 짝수, 홀수 가 아닌 각 단어의 짝,홀수 이므로
		// 단어의 몇번째 글씨인지 나타내기 위한 index
        int index = 0;

		// 한 글자씩 찾는다.
        for(int i=0;i<s.length();i++){
			// 비교 할 문자 추출
            temp = s.charAt(i);
			
			// 공백이라면 index 를 0으로 만들고 글자를 추가해준다.
			// 추가해주지 않으면 밑의 continue 로 인해 공백이 생략된다.
			// continue 를 해주지 않는 경우, index++ 로 인해 두번째 단어부터 index가 꼬인다.
			// "TrY hElLo wOrLd" 처럼 표시 될 것이다.
            if(temp == ' '){
                index = 0;
                sb.append(temp);
                continue;
				
			// 홀수번째고, 대문자 일 경우 +32 로 소문자로 변경해준다. 이하 마찬가지
            }else if(index % 2 == 1 && 'A' <= temp && temp <= 'Z'){
                temp+=32;
            }else if(index % 2 == 0 && 'a' <= temp && temp <= 'z'){
                temp-=32;
            }
            index++;
            sb.append(temp);
        }

        return sb.toString();
    }
}