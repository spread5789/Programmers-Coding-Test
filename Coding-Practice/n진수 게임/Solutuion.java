class Solution {
	// 진수를 구하기 위해서 16진수까지 저장을 해 둔다. (진수는 16진수까지만 들어오는 것이 문제의 조건이기 때문에)
    String[] Array = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    
	// sb = 0부터 숫자까지 모든 수들을 진법 변환한 문자열
	// answer = sb 에서, 튜브의 차례에 오는 숫자들만 모아둔 문자열
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb= new StringBuilder();
        StringBuilder answer=new StringBuilder();

		// 0부터, 숫자까지 모든 문자열을 진법 변환.
		// 튜브가 구할 t번째 숫자를 구할 수 있는 만큼 (t*m) 구한다.
        for(int i=0;sb.length()<t*m;i++)
            sb.append(getNum(i,n));
        
		// 튜브의 차례에 해당되는 숫자들 추출.
		// p-1 인 이유는, 첫번째 차례라면 인덱스는 0이기 때문에 -1을 해줘야 함.
        for(int i=p-1;answer.length()<t;i+=m)
            answer.append(sb.charAt(i));
        
		// 실패했던 코드에 있던 toUpperCase 는 없어도 된다.
		// 대문자로 Array 에 미리 입력해두었기 때문
        return answer.toString();
        
    }

    // 진법 변환
    public String getNum(int num, int n){
        StringBuilder sb = new StringBuilder();
        
        do{
            sb.append(Array[num % n]);
            num/=n;
        }while(num != 0);
        
		// 역순으로 추가해주는것은 진법 변환의 기본이다.
        return sb.reverse().toString();
    }
}