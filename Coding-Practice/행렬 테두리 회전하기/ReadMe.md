문제
==
![1](https://user-images.githubusercontent.com/73854324/120260685-5a11c700-c2d1-11eb-8a3e-d67e9bbf22ab.PNG)
![2](https://user-images.githubusercontent.com/73854324/120260687-5b42f400-c2d1-11eb-8d2a-cea4cfb71f2c.PNG)
![3](https://user-images.githubusercontent.com/73854324/120260689-5bdb8a80-c2d1-11eb-83af-0dcd9c987527.PNG)
![4](https://user-images.githubusercontent.com/73854324/120260690-5bdb8a80-c2d1-11eb-919a-76cc3beac57c.PNG)
![5](https://user-images.githubusercontent.com/73854324/120260692-5d0cb780-c2d1-11eb-9635-81a0c76fc8ea.PNG)
<br><br>
==
얼마나 구현해낼 수 있는가에 대한 문제인 것 같다.
   
회전 메서드에서 마지막 상단 반복문 중 x1+1 까지만 회전 한 이유는   
처음 회전을 시작하기 전 가장 상단 우측값, 즉 (x1,y1)의 값을 temp 변수에 보관해두고 이를 그 자리에 채워주기 위함이다.   
그냥 x1 까지 돌려도 temp로 덮어씌어질 것이기 때문에 x1+1이 아닌 x1 까지만 해도 상관은 없다.