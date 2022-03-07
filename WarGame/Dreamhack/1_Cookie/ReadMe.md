문제
==
![1](https://user-images.githubusercontent.com/73854324/157080124-dfe71e24-defb-4e42-9686-dd19aa48462a.png)
<br><br>
==

![2](https://user-images.githubusercontent.com/73854324/157080129-0c73a853-b180-4558-9ec0-9e9b45957a60.png)<br>
처음 접속하면 이런 화면이 나온다.
<br><br>
![3](https://user-images.githubusercontent.com/73854324/157080130-d50041d4-15d7-498c-92aa-7ea6a131b049.png)<br>
어떤 코드로 되어있는지 파악하기 위해 소스를 봤는데, 주석으로 guest 계정의 힌트가 있다.
<br><br>
![4](https://user-images.githubusercontent.com/73854324/157080132-3464ce19-3acc-4fd0-bb4d-8b65e300274c.png)<br>
게스트 계정으로 로그인 후, Home 을 눌러 재 접속을 요청하고 패킷을 관찰해보았다.
<br><br>
![5](https://user-images.githubusercontent.com/73854324/157080134-7063754f-92fc-4643-9ab8-a516d2e58902.png)<br>
쿠키에 유저에 대한 식별정보가 적혀있다.
<br><br>
![6](https://user-images.githubusercontent.com/73854324/157080137-36cc0e67-ae0f-480e-8018-371339d762ab.png)<br>
내 신분을 증명해 줄 쿠키값을 admin 으로 변경해보았다.
<br><br>
![7](https://user-images.githubusercontent.com/73854324/157089553-e2a1f138-2bb8-4517-82c0-205da08ce1cf.png)<br>
성공적으로 flag 값을 획득할 수 있었다.
<br><br>