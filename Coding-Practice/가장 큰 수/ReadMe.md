리뷰
==
<br>

설명은 언제나 java 파일 내 주석에..
--
<br>
#### 처음 접근방식은 이러했다.   
가장 앞에있는 숫자만 추출해서 그 숫자가 큰 순서대로 기존의 숫자들을 붙여서 리턴해주는것.   
어쨋든 구현은 포기했다.<br><br>
Map 을 사용해야하나..? 같은 생각이 떠오르긴 했는데 바로 접었고..음   
무엇보다 큰 숫자가 여러 개 이면 매핑해주는 방법에서부터 벌써 코드가 길어지고, 효율과 가독성에서부터 문제가 될 것이다.
<br><br><br>
#### 이 후, 다른 접근방식이 떠오르지 않아서 질문게시판 글들을 1~2개 정도 봤는데,   
그렇게 큰 도움은 얻지 못했고.. 결국 구글링을 시도하게되었다.   
구글링을 하는데 사람들의 코드가 다 똑같았다(?!)<br>
접근방식에 대해 생각하지도 못하게 쉬운 방법이 있었다..
<br><br><br>
![1](https://user-images.githubusercontent.com/73854324/115187256-f5821a80-a11d-11eb-8cab-69ace127a8de.PNG)
#### 그냥 문자로 정렬해주면 되는것이었다. (사진은 접근방식에 대해 헤매다가 아이디어에 도움을 주신 마이크로소프트 상담사(?) 님)
그제서야 문제의 카테고리가 정렬인것이 눈에 들어왔다.. 엉;;<br>
https://blog.naver.com/occidere/220918234464<br>
정렬하는 과정중에서 찾은 블로거 한 분이다.<br>
Comparable 인터페이스와 Comparator 클래스에 대해 이해하기 쉽게 설명해놓으셔서 도움이 되었다.<br><br>

![2](https://user-images.githubusercontent.com/73854324/115187260-f74bde00-a11d-11eb-9cf7-33deb050755c.png)
![3](https://user-images.githubusercontent.com/73854324/115187262-f7e47480-a11d-11eb-8f83-3a5e95b09cf4.PNG)
![4](https://user-images.githubusercontent.com/73854324/115187264-f7e47480-a11d-11eb-99f7-e0ea0db9d6f3.PNG)<br><br><br>
이건 그냥 혼자 오.. 하고 깨달으면서 찍은 사진들.. <br><br>
![5](https://user-images.githubusercontent.com/73854324/115187266-f87d0b00-a11d-11eb-8b52-ce240eb4ef98.PNG)<br>
![6](https://user-images.githubusercontent.com/73854324/115187267-f915a180-a11d-11eb-9222-fc18619db298.PNG)<br>
문자형식으로 처리했기때문에 0 이 아닌 000 이 나온 모습인데..<br>
주석으로 설명 달아놨는데 사진은 왜 찍어놨는지 잘 모르겠다.<br>
