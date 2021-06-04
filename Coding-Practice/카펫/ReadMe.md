문제
==
![1](https://user-images.githubusercontent.com/73854324/120759605-255e7380-c54e-11eb-93c7-36f84947150e.PNG)
![2](https://user-images.githubusercontent.com/73854324/120759613-268fa080-c54e-11eb-858f-f7e1ca20e8e1.PNG)
<br><br>
==
처음 풀이는 Solution(fail).java 와 같다.   
그러나 틀렸다는 답을 듣고 또 다른 규칙성이 있는지 살펴보았다.   
   
![제목 없음](https://user-images.githubusercontent.com/73854324/120759668-3313f900-c54e-11eb-9c9c-747a1983d767.png)   
(그림은 혼자 생각하느라 대충 그린거니 각 사각형의 크기는 신경쓰지 말자 ㅠㅠ)   
<br> 
yellow 영역은 전체 가로와 세로 길이의 -2 만큼 뺀 부분임을 알 수 있다.   
즉, yellow = (가로-2)X(세로-2) 가 된다.   
해당 규칙을 추가해주니 무사히 통과했다.   
   
처음 w 값을 Math.sqrt(brown) 으로 정한 이유는, brown 은 테두리를 둘러싸기 때문에 가로길이X2 값보다 무조건 크기 때문이다.   
그냥 불필요한 탐색을 줄이기 위함이라고 생각하면 된다.