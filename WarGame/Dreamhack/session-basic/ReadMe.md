문제
==
![1](https://user-images.githubusercontent.com/73854324/157713782-896f71c2-0054-4e91-b281-85e39032c1fc.png)
<br><br>
==
<br><br>
![3](https://user-images.githubusercontent.com/73854324/157713795-9c93ec7a-0646-4f81-a8a5-bba6b9d407d3.png)<br>
보이는 것이라고는, Home, About, Login 3개가 끝이다.   
당연히 Login 페이지가 핵심일 것이다.    
<br><br>
![2](https://user-images.githubusercontent.com/73854324/157713791-e0b43a73-0cc4-4ec4-9a8d-206a0b766753.png)<br>
우선, 페이지 소스코드부터 살펴보았다.   
주석으로 guest/guest 로 적혀있다.   
<br><br>

![4](https://user-images.githubusercontent.com/73854324/157713797-71728516-0159-4438-b280-0513815c0cfa.png)<br>
guest 계정으로 로그인에 성공했고, 서버에서 할당해 준 쿠키값을 확인했다.   
음.. admin 으로 로그인을 하려면 guest 의 쿠키값(세션ID) 로는 불가능한데 우선은 기억해두었다. (1cc8f6~)   
<br><br>
![5](https://user-images.githubusercontent.com/73854324/157713800-996a5cad-7949-45c0-903f-f9fdaa651e29.png)<br>
우선 문제파일(소스)를 보기로 했다.   
음? guest 외에 user 라는 아이디와, admin 이라는 아이디가 있다.   
당연히 admin 으로 로그인에 성공해야지 FLAG 값을 알아낼 수 있을 것 같다.   
우선은 user 로 다시 로그인해보았다.   
<br><br>
![7](https://user-images.githubusercontent.com/73854324/157713801-1458137e-4072-45d2-a551-3648ac5073cd.png)<br>
user 로 로그인 한 결과, 당연히 웹서버에서 할당해 준 쿠키값이 변경되었다.   
우선 이것도 기억해두자. (3b9b17~)   
필요한 것은 admin 의 세션값이다.   
<br><br>
![8](https://user-images.githubusercontent.com/73854324/157713805-96ee5d85-c132-47d4-8ef6-819db5f98727.png)<br>
코드를 마저 살펴보았다.   
하단부에 /admin 에 대한 페이지도 숨겨져있었다.   
딱 봐도 의심되어보인다.   
우선 접속해보자.   
<br><br>
![9](https://user-images.githubusercontent.com/73854324/157713809-f4deb05b-9d56-4a15-9368-8f78585a77f0.png)<br>
(guest 나 user 가 여러개인 것은 무시하자.)   
서버의 세션저장소가 JSON 형식으로 저장되어있었다.   
아까 로그인해서 할당받은 guest(1cc8f6~) 과 user(3b9b17~) 의 세션값들도 저장되어있다.   
그리고 무엇보다, 우리의 목적인 admin 계정에 대한 세션이 있었다.   
그렇다면, 우리의 요청헤더에 담겨있는 쿠키값을 admin 계정의 쿠키값으로 바꿔치기한다면,   
admin 계정에 성공 할 것이다.   
<br><br>
![10](https://user-images.githubusercontent.com/73854324/157713812-da962ab8-32f9-4382-9b91-ce9a0b90053f.png)<br>
BurpSuite 툴을 사용해서, 내가 보내는 요청패킷의 쿠키값을 전 이미지의 admin 세션값으로 바꿔치기했다.   
<br><br>
![11](https://user-images.githubusercontent.com/73854324/157713821-66204e41-88c5-4175-a10e-6794203445e3.png)<br>
성공적으로 admin 계정에 성공했다.   
세션을 탈취하는, 흔히 세션 하이재킹 이라고 불리는 공격기법을 활용하는 간단한 문제였다.   
<br><br>