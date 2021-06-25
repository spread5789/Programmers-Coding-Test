import java.util.*;

class Solution {
  public String[] solution(String[] files) {
		Arrays.sort(files, new Comparator<String>() {
			public int compare(String o1, String o2) {
                // h1, h2 는 헤더이다.
                // 헤더는 숫자가 아닌 문자로 이루어져 있으니 숫자를 기준으로 원래 문자를 split 한다.
                // [0-9] 는 정규표현식이다.
                // 숫자를 기준으로 나눈 후 앞 배열부분이 HEAD 부분이기 때문에 [0] 인덱스를 가진다.
				String h1 = o1.split("[0-9]")[0];
				String h2 = o2.split("[0-9]")[0];
                
                // 두 헤더를 비교한다
				int result = h1.toLowerCase().compareTo(h2.toLowerCase());
                
                // 값이 같다면 정렬기준을 숫자를 보고 결정해야하기 때문에 숫자를 찾는다.
				if ( result == 0 ) 
                    // 찾은 정수를 각각 빼서 리턴해준다.
					result = findNum(o1,h1)-findNum(o2,h2);
                
                // ★ 이 때의 정수값은, compare 메소드의, Comparator 인터페이스의 정렬기준에 해당된다. 파일명이 아니다.
				return result;
			}
		});
		return files;
  }
    
// 숫자만 찾는 메소드이다.
// s 는 원래 파일명,
// h 는 메소드 진입 전에 구한 HEAD 이다.
private int findNum(String s, String h) {		
        // 원래 문자에서 헤더를 없애준다. (남는 부분은 NUMBER , TAIL)
		s = s.replace(h, "");
		String result ="";
    
        // 숫자는 5자리까지 올 수 있다.[문제 조건 : 0부터 99999 까지]
        // NUMBER 와 TAIL 만 남은 문자를 하나씩 탐색하면서, 숫자인지 판단하며 결과에 넣는다.
		for( char c : s.toCharArray()) {
			if( Character.isDigit(c) && result.length() < 5 ) {
				result+=c;
			}else
				break;
		}
        // 구해진 문자 결과를 정수로 변환하여 리턴한다.
        // 정렬 기준이 문자열이라면 0, 1, 10, 2, 3 ...
        // 정렬 기준이 정수    라면 0, 1, 2, 3, ... 이렇게 정렬되기 때문이다.
		return Integer.valueOf(result);
	}
}