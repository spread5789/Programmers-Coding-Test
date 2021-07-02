문제
==
![1](https://user-images.githubusercontent.com/73854324/124235220-effa7500-db4f-11eb-9894-d559c0540224.PNG)
![2](https://user-images.githubusercontent.com/73854324/124235225-f12ba200-db4f-11eb-84aa-c2963965311b.PNG)
![3](https://user-images.githubusercontent.com/73854324/124235226-f1c43880-db4f-11eb-8bbc-83e12df3e19c.PNG)
<br><br>
==
문자열만 잘 다룰 수 있다면 풀 수 있는데 문제인데.. 이런 걸 많이 해본적이 없어서 쉬운 문제인데도 나한테는 힘들었다.   
   
![5](https://user-images.githubusercontent.com/73854324/124234885-93975580-db4f-11eb-8d61-3cb62bf64f60.PNG)   

```
s.substring(2,s.length()-2).replaceAll("\\},\\{","-").split("-");
```
처음에 이렇게 파싱하면, 이런 결과가 나왔다.   
, 를 다시 나눠 줄 필요가 있었다.   
   
![6](https://user-images.githubusercontent.com/73854324/124234893-94c88280-db4f-11eb-9728-700a2a425e76.PNG)
반복문에 메서드를 사용할 수 있다는 사실이 익숙하지 않아 뻘짓을 정말 많이 했다. (코드가 불필요하게 많아진다던지)
   
또한, 처음에는 ArrayList 를 사용하였는데, contains() 메서드가 == 가 아닌, equals() 와 같이 동작한다는 것을 알아서 이미 가지고있는지 확인하려면 비효율적인 코드가 되어버렸다.   
그래서 문자열 상태로 체크 후, answer 에 답을 옮겨줄 때에만 Integer 로 변환했다.