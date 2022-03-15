Bee Box
---
![1](https://user-images.githubusercontent.com/73854324/157915812-8af6d3f1-174e-4eb5-9ded-68773412dfff.jpg)
<br>
웹 애플리케이션에서 자주 발생하는 취약점을 구축한 환경을 bWAPP(buggy Web Application)이라고 한다.   
buggy란 버그의 형용사로서 말 그대로 웹 애플리케이션에 버그, 곧 취약점을 뜻한다.   
<br>
bee-box는 bWAPP의 설치와 설정을 모두 완료하여 설치 없이 바로 활용할 수 있도록 만들어진 CD이다.   
beebox를 쓰는 경우 ISO로 설치하지 않고 만들어진 이미지를 불러온다.   
<br>
bee-box를 사용하면 모든 bWAPP 취약점을 탐색 할 수 있다.   
bee-box는 bWAPP 웹 사이트를 해킹하고 훼손하는 여러 가지 방법을 제공한다.   
<br>
취약점은 국제 웹 보안 표준 기구인 OWASP TOP 10 기준이다.   
쉽게 말해 bee-box는 OWASP 취약점이 반영된 모의 해킹 연습 사이트라고 생각하면 된다.   
비슷한 연습용 사이트로 WebGoat가 있고, 웹 사이트에서 운영되는 사이트는 webhacking.kr이 대표적이다.   
<br>
즉, 이미 취약점이 있는 php + mysql 로 만들어진 VM 가상머신이다.   
환경구축을 간단하게할 수 있고 적당한 취약점이 있는, 나같은 초보자에게 유용한 툴이다.   

Install
---
![2](https://user-images.githubusercontent.com/73854324/157917104-a0231b29-5def-4ccd-9f57-fbe9acd92801.png)<br>
https://sourceforge.net/projects/bwapp/files/bee-box/
직접 취약한 페이지를 구축하기 위해서는 bWAPP 를 설치하는데,(빨간색으로 체크해놓은 것)   
설정까지 완료된 이미지를 받기 위해서 bee-box 를 설치한다.(bee-box_v1.6.7z)   
<br><br>
![3](https://user-images.githubusercontent.com/73854324/157917944-c73b8502-c87e-4648-a32c-023a7d328806.png)<br>
용량은 1.134 GB 이며, 가상머신에 올리기 위해 VMWare 역시 필요하다.   
<br><br>
![4](https://user-images.githubusercontent.com/73854324/157922513-18b0bf1c-7234-4ae3-8ab7-a583a3482b90.png)<br>
추가 후, 나는 메모리만 2GB 정도로 주고,   
이미 설정이 끝난 이미지를 받은 것이기 때문에, I Copied It 버튼을 눌러주었다.   
<br><br>
![5](https://user-images.githubusercontent.com/73854324/157923203-d094c8c4-4092-479a-bfa3-fafebd747a07.png)<br>
설치 초기에 키보드 설정이 벨기에 언어이기 때문에, 한국어로 변경이 필요하다.   
<br><br>
![6](https://user-images.githubusercontent.com/73854324/157923569-a1b52eec-3201-4b02-ab7c-1ff703191f7e.png)<br>
![6](https://user-images.githubusercontent.com/73854324/157923712-e3a8a328-df27-45af-a399-d6dc13fa31d5.png)<br>
한국어 추가 후, 벨기에 언어를 Remove 해주고, 한국어의 Default 를 체크해주자.   
<br><br>
![7](https://user-images.githubusercontent.com/73854324/157923905-d9be23c5-35aa-4c69-a8d6-a6117ee20c0c.png)<br>
그 후, bWAPP - Start 를 실행시키면 웹 브라우저로 홈페이지가 하나 뜰 것이다.   
기본 비밀번호는 다운받은 bee-box_v1.6 폴더 내부에 ReadMe.txt 파일로 적혀있다.   
<br><br>
![8](https://user-images.githubusercontent.com/73854324/157924148-e4194329-1a24-42ee-b669-84622d2efdf0.png)<br>
로그인 하단에 보이는 low, medium, high 는 문제 난이도 라고 생각하면 된다.(보안 수준 설정)   
<br><br>
End
---
비박스 설치가 끝났지만, 웹 뿐만 아니라 터미널도 취약하다고 한다.   
그리고 힌트가 없기 때문에 문제 푸는데 시간이 많이 걸린다.   
하지만 이러한 시간이 나를 성장시킬 것이다.   
<br>
당연히 Kali Linux, Burp Suite 를 적절히 사용하여야 연습할 수 있다.   
