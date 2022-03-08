문제
==
![1](https://user-images.githubusercontent.com/73854324/157178729-3ccd8bea-1293-4d48-ba26-128296afa585.png)
<br><br>
==

<br><br>
![2](https://user-images.githubusercontent.com/73854324/157178735-f0353cbe-8b19-490d-8a0b-c7c488b3b2f2.png)<br>
접속하게 되면, 로그인밖에 없네?   
<br><br>
![3](https://user-images.githubusercontent.com/73854324/157178736-0b0c28c0-0eb8-434b-813f-960636bd6572.png)<br>
간단하게 SQL Injection 문을 넣어보았다.   
password 는 아무거나 쳤다. (-- 에 의해 주석처리 될 것이다)   
<br><br>
![4](https://user-images.githubusercontent.com/73854324/157178737-16e56095-35db-482a-8cfb-cf82a92dc37b.png)<br>
음..? 아예 안된다.   
<br><br>
![5](https://user-images.githubusercontent.com/73854324/157178738-b51db43f-82a6-4689-ac27-96daa8d7f0a0.png)<br>
서버 단에서 작성 된 SQL 쿼리문을 모르기 때문에,   
' -> " 로 변경시켜보았다.   
<br><br>
![6](https://user-images.githubusercontent.com/73854324/157178739-e9af78e7-0c60-40cd-ac2b-936223f1b71f.png)<br>
어.. 게스트로 로그인 할 수 있었다.   
<br><br>
![7](https://user-images.githubusercontent.com/73854324/157178745-98e6258a-a647-4d7e-8e8e-607cee50fbe4.png)<br>
그렇다면 대표적으로 guest 도 있으니, admin 계정도 있지 않을까?   
<br><br>
![6](https://user-images.githubusercontent.com/73854324/157178739-e9af78e7-0c60-40cd-ac2b-936223f1b71f.png)<br>
or 1 구문을 지우지 않아서, 첫번째 쿼리 결과문이 나왔다.   
<br><br>
![8](https://user-images.githubusercontent.com/73854324/157178748-97a2b5fa-21ed-4d19-8f03-676f9a982a78.png)<br>
제대로, userid 는 admin 이며, 비밀번호 검증은 하지 않겠다고 주석을 주입시켰다.   
<br><br>
![9](https://user-images.githubusercontent.com/73854324/157178861-a475dead-7e92-4634-94d6-b683420f594b.png)<br>
flag 획득 완료..? 갑자기?   
<br><br>