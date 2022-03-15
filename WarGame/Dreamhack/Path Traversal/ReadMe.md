문제
==
![1](https://user-images.githubusercontent.com/73854324/157087902-e02ad6b7-07d8-4221-b6f6-5da1df6ccbe3.png)
<br><br>
==
![2](https://user-images.githubusercontent.com/73854324/157087906-f4679605-f9e1-4195-8c38-94e517af62d7.png)<br>
접속하면 Get User Info 외에는 특별한 변화가 없다.   
<br><br>
![3](https://user-images.githubusercontent.com/73854324/157087908-760b876d-3b5d-4fb8-8901-85da3f1c17e3.png)<br>
userid 를 적는 input 태그가 있고, 일단 View 를 눌러 결과를 확인해보자   
<br><br>
![4](https://user-images.githubusercontent.com/73854324/157087910-533b9e89-10e5-4abe-8204-a0af09099a70.png)<br>
user 들에 대한 정보가 나오는 기능인 것 같다.   
그리고, View 를 누르는 동시에 입력값이 guest 에서 0으로 바뀌었다.   
<br><br>
![5](https://user-images.githubusercontent.com/73854324/157087913-e590436e-2723-4831-b419-658005f0fbe3.png)<br>
소스코드를 확인해보니, userid 값을 자동으로 변동시키도록 자바스크립트가 작성되어있었다.   
<br><br>
![6](https://user-images.githubusercontent.com/73854324/157087914-7ca0d295-c290-4309-8d4e-305ba65f3042.png)<br>
문제에 있는 코드를 확인해보니, flag 의 위치와 POST 방식이 어떻게 동작하는지 적혀있었다.   
즉, /api/flag 를 획득하려면, ../flag 를 조회하면 flag 값을 획득할 수 있다.   
<br><br>
![7](https://user-images.githubusercontent.com/73854324/157087917-63789151-83b9-4d9e-828f-a7e299f31b95.png)<br>
BurpSuite 을 이용해서 userid 를 ../flag 로 변경시켜주었다.   
(자바스크립트가 자동으로 바꾸기 때문에 패킷을 변조했다.)   
<br><br>
![8](https://user-images.githubusercontent.com/73854324/157087921-23f22ac4-bf0e-4fee-be06-1a8c68568172.png)<br>
플래그 값을 획득할 수 있었다.   
<br><br>
![9](https://user-images.githubusercontent.com/73854324/157087924-11508587-4343-4cd3-9414-95ec05051613.png)<br>
자바스크립트에서 자동으로 입력값을 변경시키는 부분을 지우고, ../flag 를 조회해도 된다.   
<br><br>