import java.util.*;

class Solution {

    /** n자리의 수로 만들수 있는 조합 => n!(팩토리얼)
     *
     * char[] chs - 뽑은 숫자를 저장 (처리는 char로 할 것임)
     * boolean[] visited - 뽑았는지 확인하는 변수
     * HashSet set - 중복은 필요없으니 set 자료구조 사용
     *
     */

    // 멤버변수
    static char[] chs;
    static boolean[] visited;
    static HashSet<Integer> set;

    public int solution(String numbers) {

        visited = new boolean[numbers.length()];
        set = new HashSet<>();

        for(int i=1; i<=numbers.length();i++){
            chs = new char[i];
            permutation(0, i, numbers.length(), numbers);
        }

        return set.size();
    }

    public void permutation(int start, int end, int length, String numbers) {
        // 모두 뽑았을 경우 (재귀 종료 조건)
        if(start == end){
            // 숫자는 처음에 0이 나오면 안된다.
            // 0이 처음숫자로 뽑혔을 경우 그냥 pass
            if(chs[0] == '0') return;

            // 뽑은 문자를 숫자형으로 변환해줌.
            int num = Integer.parseInt(String.valueOf(chs));

            // 소수일경우 set 에 넣어준다.
            if(isPrime(num))
                set.add(num);

            return;
        }

        for(int i=0;i<length;i++){
            // 이미 뽑은 수일 경우 뽑지 않는다.
            if(visited[i]) continue;

            visited[i] = true;
            chs[start] = numbers.charAt(i);
            permutation(start+1,end,length,numbers);
            visited[i] = false;
        }
    }

    // 소수 판별 메소드
    private boolean isPrime(int num) {
        // 1은 소수가 아니다
        if(num == 1) return false;

        // 2부터, 판별하려는 수의 제곱근까지 나눈다.
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num % i == 0) return false;
        }

        // 나눠지는 수가 있다면 소수가 아니고, 없다면 소수이다.
        return true;
    }
}