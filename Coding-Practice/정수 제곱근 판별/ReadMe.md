문제
==
![캡처](https://user-images.githubusercontent.com/73854324/117563392-7fe7e980-b0e0-11eb-9d37-ef96b38bf423.PNG)
<br><br>
==
처음엔 for 문을 사용하여 하나하나 찾았지만   
꼭 처음부터 탐색 할 필요가 있을까?   

실행시간
![1](https://user-images.githubusercontent.com/73854324/117563551-bbcf7e80-b0e1-11eb-8469-b269bda926ab.PNG)
   

이러한 문제때문에 다시 작성한 코드는 아래와 같았다.
```
class Solution {
    public long solution(long n) {
        if(Math.pow(Math.sqrt(n),2)==n)
            return (long)Math.pow(Math.sqrt(n)+1,2);
        
        return -1;
    }
}
```
   
하지만 결과는..
![캡처](https://user-images.githubusercontent.com/73854324/117563464-04d30300-b0e1-11eb-97ca-24611160f078.PNG)
문제는 조건문에 있었다.   
```
if(Math.pow(Math.sqrt(n),2)==n)
```
   
문제에서는 양의 정수 n 이 입력값으로 주어지는데, (long 타입으로 정수를 받는다)   
Math.pow 의 파라미터 밑 결과값은 double 형이기 때문에 문제가 원하는 조건과 맞지 않는다.   
   
Math.sqrt(n) 에서 n 의 제곱근을 구할때 소수점을 버리지 않아서 생기는 문제였기에,   
(int) 로 형변환을 시켜 소수점을 버린 후 정상적으로 통과할 수 있었다.   
   

실행시간   
![2](https://user-images.githubusercontent.com/73854324/117563550-bb36e800-b0e1-11eb-83f9-3cdd40b4f84f.PNG)