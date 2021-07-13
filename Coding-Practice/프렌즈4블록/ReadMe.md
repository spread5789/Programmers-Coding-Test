문제
==
![1](https://user-images.githubusercontent.com/73854324/125456259-e255e1c0-5a5b-4ae1-a276-cb31d49088a3.PNG)
![2](https://user-images.githubusercontent.com/73854324/125456266-71bed323-6625-4168-8052-c5605e358dd8.PNG)
![3](https://user-images.githubusercontent.com/73854324/125456272-332eee33-5d85-4524-9180-e9a99def08f4.PNG)
![4](https://user-images.githubusercontent.com/73854324/125456275-a1ac25c5-afee-43b6-aad9-35d9ea0b8123.PNG)
<br><br>
==
먼저, 제거될 수 있는 블럭들을 체크하는 배열이 추가로 필요하다.   
   
바로 생각 난 방법으로는 2가지가 있었는데,
```
1. boolean 으로 삭제될 수 있는 블럭들만 true 로 바꾼다.
2. 임시로 복제하여 제거한 후 원본테이블과 다른부분들의 개수를 센다.
```
2번의 방법으로 풀었다.   
   
이번에도 주석이 많아서.. 주석이 없는 코드만 따로 적었다.   
클래스 명은 Solution 그대로이니 실행해볼때 주의하자.