회고
==
DFS 문제를 직접 마주한 적은 처음이다.   
접근방식은 생각이 났지만 코드로 어떻게 구현해야할지 감이 잘 잡히지 않았다.   
DFS 코드들을 많이 찾아보기도 하고 다른 사람의 코드를 보며 최대한 내 것으로 만들려고 노력했는데 효과가 있었을지 모르겠다 제발..   
설명은 주석으로 상세하게 써놓았고, 풀다가 index 에러가 계속 발생해서 디버그를 돌려봤다<br><br>
![115156663-53801500-a0c0-11eb-97e2-81502997eee6](https://user-images.githubusercontent.com/73854324/115156886-7f4fca80-a0c1-11eb-8615-3213cec82a87.png)
<br>

```
x >= visited[y].length || y >= visited.length
```
처음에는 이렇게 작성했었는데 계속 IndexOutofBoundsException 이 발생했다.
visited[y] 에서 발생하는 문제였어서 IDE를 사용하지 않는 환경에서 쉽게 발견하지 못했었다.


```
y >= visited.length || x >= visited[y].length
```
이렇게 변경해주니 오류가 발생하지 않았다.   
조건문 검사하는 로직은 어떻게 되어있는지 궁금해졌다. 찾아보러 가야지   



문제
==
![1](https://user-images.githubusercontent.com/73854324/115156693-790d1e80-a0c0-11eb-9253-9946ce6e757a.PNG)
![2](https://user-images.githubusercontent.com/73854324/115156696-79a5b500-a0c0-11eb-8628-0e6f284e66d1.PNG)

예시 그림을 그려보면 이렇습니다.   
![제목 없음](https://user-images.githubusercontent.com/73854324/115156784-f33da300-a0c0-11eb-909b-07195ea1e2e2.png)
```
영역 = 4개
최대영역 = 5칸

출력 => [4, 5]
```