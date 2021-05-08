문제
==
![캡처](https://user-images.githubusercontent.com/73854324/117540983-b70cbb00-b04c-11eb-9e0e-e9a5c16c33b5.PNG)
<br><br>
==
return 타입은 int[] 이다.   
그래서 long 형을 int 형으로  변환했는데 정말 바보같았다.   
```
n은 10,000,000,000이하인 자연수입니다.
```
이 조건이 달려있는데도 변환해서 풀었던 것이다.   
   
생각나는 방법은, n 을 String 혹은 char 타입으로 나눠서 푸는 것인데,   
String 으로 나눠서 풀었다.   

그 방법은,      
String 의 split() 을 사용할 지,   
char 의 toCharArray() 를 사용할 지 이다.
   
String / char 를 사용하지 않는 방법도 있다.   
'''
int count = 0;

while(n>0){
	answer[count]=(int)n%10;
	n/=10;
	count++;
}
'''
대충 즉석에서 짜 본 코드이다.. 틀린거 있나?   
   
여기서 count 변수는 자리수를 나타내는데,   
5 자리일 경우, answer 배열의 길이는 5가 되도록 나타내기 위해 사용했다.
