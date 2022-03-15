문제
==
![1](https://user-images.githubusercontent.com/73854324/157462858-6942c3b9-4d90-4f04-ac6a-11eff122fb13.png)

<br><br>
==
<br><br>
![2](https://user-images.githubusercontent.com/73854324/157462862-40d12912-f159-46cc-b6e3-71ff0d49f2fe.png)<br>
문제 페이지에 접속하면,   
XSS 공격이 가능 한 vuln(xss) page.   
GET 방식으로 받은 memo 값을 추가시켜주는 memo 페이지.   
<br><br>
![1](https://user-images.githubusercontent.com/73854324/157478182-715d1a1e-fcac-4195-a459-17ea7e5ed3aa.png)<br>
memo 페이지는 스크립트 문이 출력이 될 뿐, 실행되지는 않았다.   
vuln 페이지만 필터링 처리가 되어있지 않은 듯 하다.   
<br><br>
![3](https://user-images.githubusercontent.com/73854324/157462866-bd173135-5373-4196-82d7-2a25cb1309c6.png)<br>
그리고 뭔가를 입력하는 flag 페이지가 있다.   
<br><br>
![4](https://user-images.githubusercontent.com/73854324/157462867-e7b65509-1569-4efe-af5b-4bc71ababc31.png)<br>
소스코드를 살펴보았다.   
플라스크는 모르지만 소스를 유추해서 읽을 수는 있으니 도전..!   
<br>
vuln 페이지는 param 명으로 받은 파라미터를 그대로 돌려준다.   
(XSS 공격이 가능한 페이지)   
<br>
flag 페이지는, GET 방식일 경우 flag.html 페이지를 보여주고,   
GET 외의 (POST) 요청일 경우, param 명의 파라미터를 받는다   
그리고.. 딱 보아도 의심되는 FLAG.strip() 가 있었다.   
그 후 good 이라는 메시지와 함께, 전 페이지로 이동한다.   
<br>
check_xss 함수의 경우,   
키,값 형식의 쿠키를 담는 것 같고,   
해당 쿠키는 http://127.0.0.1:8000/vuln?param={이 곳으로 보내는 것 같다}   
<br>
설명이 많이 이상하긴 하지만,   
flag 페이지에 넣은 파라미터 값을 memo 페이지에 출력할 수 있을 것 같다.   
< 문자 또한 &lt 로 치환처리 되서, 아까 스크립트가 실행되지 않았던 모양이다.   
<br><br>
![5](https://user-images.githubusercontent.com/73854324/157462869-7713c554-d0e3-4a79-a528-e2a70d3c0019.png)<br>
<script>location.href="/memo?memo="+document.cookie;</script>   
라는 내용을 flag 페이지에 전송해보았다.
<br><br>
![6](https://user-images.githubusercontent.com/73854324/157462872-10c94852-0fc3-4102-ad30-a87f60963a6e.png)<br>
많은 뻘짓때문에 hello 가 많긴 하지만, flag 값이 나왔다.   
<br>
flag 값은 쿠키에 담겨있었군!
<br><br>
상세하게 정리해주신 다른 분 글 계속 읽어보기   
https://mokpo.tistory.com/59   