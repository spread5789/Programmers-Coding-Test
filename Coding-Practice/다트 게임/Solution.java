class Solution {
    public int solution(String dartResult) {
		/**
		* prev = 이전 숫자를 저장해놓음 (*이 나올 경우, prev 의 값이 변동되기때문에)
		* curr = 현재 숫자를 저장해놓음
		* sum = 총 합계
		*/
        int prev = 0;
        int curr = 0;
        int sum = 0;
		
		// String 문자열을 한 글자 씩 배열에 char 형식으로 담습니다.
        char[] dart = dartResult.toCharArray();

		// 지금부터 입력받은 문자열의 한 글자씩 차례대로 탐색합니다.
        for(int i=0;i<dart.length;i++){
		
			// 확인한 글자가 숫자라면 [(ASCII)48 -> (int)0 , (ASCII)57 -> (int)9)]
            if(dart[i] >= 48 && dart[i] <= 57){
				// char 형식에 -'0' 을 해주면 손쉽게 int 형으로 변환됩니다.
                curr = dart[i]-'0';
				
				// 확인된 숫자가 1이라면, 1인지 10인지 확인해야합니다.
				// 뒷 글자가 0이라면 curr 는 10으로 간주하고, 탐색변수(i)를 1 증가시켜 0의 탐색을 하지 않도록 합니다.
                if(curr==1 && dart[i+1]== '0'){
                    curr=10;
                    i++;
                }
            // 확인한 글자가 숫자가 아니라면 (조건문 내부는 문제가 요구하는 조건이니 생략하도록 하겠습니다)
            }else{
                switch(dart[i]){
                    case 'S' :
                        curr = (int)Math.pow(curr,1);
                        break;
                    case 'D' :
                        curr = (int)Math.pow(curr,2);
                        break;
                    case 'T' :
                        curr = (int)Math.pow(curr,3);
                        break;

                    case '*' :
                        curr*=2;
                        prev*=2;
                        break;
                    case '#' :
                        curr*=-1;
                        break;
                    
					// 해당 문장이 출력된다면 [0-9SDT*#] 외의 다른 문자가 입력된 것 입니다.
                    default :
                        System.out.println("제대로 입력했는지 확인해주세요.");
                        break;
                }
			// 여기서 다음에 확인할 문자가 숫자인지 확인합니다.
			// prev 변수를 만든 이유는 계산 과정에서 prev 결과값이 변경되기 때문입니다. (*에 의해)
			// 다음에 확인할 문자가 숫자라면 계산이 끝났다는 얘기이므로 prev 를 더해주고, 방금 탐색했던 curr 를 prev 로 옮겨줍니다.
            }
            if(i+1 != dart.length && dart[i+1] >= 48 && dart[i+1] <= 57){
                sum += prev;
                prev = curr;
            }
        }
		// 로직을 차근차근 보시면 아시겠지만, sum 에 더해지는 타이밍은 prev 가 curr 로 덮어씌워지기 전 입니다.
		// 만약 모든 문장을 탐색했다면 새로 들어올 curr 가 없기때문에 prev 도 당연히 덮어씌워지지 않습니다.
		// 그 말인 즉슨, 마지막 탐색과정에서의 prev 와 curr 는 sum 에 포함되어있지 않다는 얘기이므로 따로 더해줘야합니다.
        sum+=curr+prev;
        return sum;
    }
}