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
![3](https://user-images.githubusercontent.com/73854324/157462866-bd173135-5373-4196-82d7-2a25cb1309c6.png)<br>
그리고 뭔가를 입력하는 flag 페이지가 있다.   
<br><br>
![4](https://user-images.githubusercontent.com/73854324/157462867-e7b65509-1569-4efe-af5b-4bc71ababc31.png)<br>
소스코드를 살펴보았다.   
플라스크는 모르지만 소스를 유추해서 읽을 수는 있으니 도전..!   
vuln 페이지는 param 명으로 받은 파라미터를 그대로 돌려준다.   
(XSS 공격이 가능한 페이지)   
<br>

<br>
<br><br>
![5](https://user-images.githubusercontent.com/73854324/157462869-7713c554-d0e3-4a79-a528-e2a70d3c0019.png)<br>

<br><br>
![6](https://user-images.githubusercontent.com/73854324/157462872-10c94852-0fc3-4102-ad30-a87f60963a6e.png)<br>

<br><br>
