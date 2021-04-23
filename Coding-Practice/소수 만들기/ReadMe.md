문제
==
![캡처](https://user-images.githubusercontent.com/73854324/115928069-819a9600-a4c0-11eb-8da0-4cfe3707f36d.PNG)
<br><br>
==

3개의 숫자를 뽑아서 더해준 값이 소수인지 판단하는 간단한 문제.   
2 부터 타겟숫자의 제곱근 까지 나누어떨어지는 수가 없다면 소수이다.
```
for(int i=2;i<=Math.sqrt(target);i++){
	if(target % 2 == 0)
		// 1과 자기자신 외 나누어떨어지는 수가 있어서 소수가 아니다
		return false;
		
	// 나누어 떨어지는 수가 없을경우 소수이다.
	return true; 
}
