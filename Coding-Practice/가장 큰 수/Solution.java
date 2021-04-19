import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        // 숫자들을 문자로 변경 후, 문자를 내림차순으로 정렬한다.
        String[] number = new String[numbers.length];

        for(int i=0;i<numbers.length;i++)
            number[i] = String.valueOf(numbers[i]);

        // 배열을 새로운 방식(Comparator 사용)으로 정렬한다.
        // compare 메소드를 재정의함.
        Arrays.sort(number, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        // 0을 제외한 다른 숫자가 있으면 상관없지만 오로지 0만 여러개 있다면 0 하나만 출력되어야한다.
        // number[0] 에는 위 정렬에 의해 가장 큰 숫자가 문자형태로 들어가있다.
        // 이 값이 0이라면 모두 0이라는 뜻이다.
        if(number[0].equals("0")) return "0";

        // 배열로 되어있는 String[] 을 하나로 붙여서 리턴
        for(String i : number)
            answer+=i;

        return answer;
    }
}