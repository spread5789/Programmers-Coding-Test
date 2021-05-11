문제
==
![1](https://user-images.githubusercontent.com/73854324/117807186-3e00a400-b296-11eb-9369-7269e70672c7.PNG)
![2](https://user-images.githubusercontent.com/73854324/117807187-3f31d100-b296-11eb-9202-c2688827fe38.png)
![3](https://user-images.githubusercontent.com/73854324/117807189-3f31d100-b296-11eb-8a09-aca7d59f04bc.PNG)
<br><br>
==
비트연산자를 사용하면 굉장히 쉬워지는 문제이고,   
또 문제에서 원하는 정답도 비트연산자를 사용하는 것이라는 생각이 들었다.   
   
전체적인 풀이방법은 이러하다.   

```
// 1. 입력받은 각 2개의 지도의 암호(정수) 들을 2진수로 변경한다.
String map1 = Integer.toBinaryString(20);
String map2 = ~~~~~~~;

// 2. 2개의 지도 중, 한 곳이라도 벽이있다면 벽으로 간주한다.
(실제 풀이 코드에서는 위 과정과 현재 과정을 합쳐서 한 줄로 작성하였습니다.)
if(map1, map2 중 하나만 1이여도)
	해독된 맵에서는 1로 간주한다.

// 3. 1과 0을 문제의 요구대로 벽과 빈 공간으로 바꿔준다.
해독된_맵.replaceAll("1","#");
해독된_맵.replaceAll("0"," ");

```
1, 2, 3 번 과정만 보면 되긴 하다.
   
자세한 설명은 주석에 나와있다.