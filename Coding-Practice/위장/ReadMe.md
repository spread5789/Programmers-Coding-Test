문제
==
![1](https://user-images.githubusercontent.com/73854324/124080311-2fa85a80-da85-11eb-8e25-4f83d62efe2d.PNG)
![2](https://user-images.githubusercontent.com/73854324/124080317-30d98780-da85-11eb-9f9b-3b5d26563253.PNG)
<br><br>
==
처음에 경우의 수를 구하고 계속 틀리길래 시간을 좀 날렸다...   
아무것도 안입고 있을때의 경우의 수를 계속 빼주지 않았다.   
   
역시나 이번에도 코드안에 주석이 있다.   
map.getOrDefault(key, value) 메소드는,   
key 값에 해당하는 값을 반환하는데, 해당하는 key가 존재하지 않다면 매개변수인 value 를 반환한다.   
   
코드에서는 옷의 종류가 여러번 나올때마다 개수를 +1 을 해줘야해서 +1을 반드시 넣어야했고,   
기본값은 0으로 넣어두고 +1이 되어 사실상 기본값은 1로 들어간다.