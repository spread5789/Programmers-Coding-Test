문제
==
![1](https://user-images.githubusercontent.com/73854324/126093885-bc234aff-45d2-43f1-89ff-2c5406b04b71.PNG)
![2](https://user-images.githubusercontent.com/73854324/126093887-6628f125-58d6-4e4f-b589-07ba8c0d140b.PNG)
![3](https://user-images.githubusercontent.com/73854324/126093890-ec5499a1-bd09-4fa8-b5e4-168f342a5492.PNG)
![4](https://user-images.githubusercontent.com/73854324/126093892-cb6ffc17-d618-4356-8b74-2e2c48f1a948.PNG)
![5](https://user-images.githubusercontent.com/73854324/126093894-42500b33-bc0f-46ee-9f8e-359fa8723553.PNG)
<br><br>
==
check 에서는 다음 지점의 P 를 찾고,   
check_one 은 1 자리만큼 떨어져있는 P를 찾았을 때 트리거된다.   
원래 P와 새로 찾은 P 사이에 파티션이 없다면 answer=0 값을 준다.   
   
check_two 는 2 자리만큼 떨어져있는 P를 찾았을 때 트리거된다.   
원래 P와 새로 찾은 P 사이에 파티션이 없다면 answer=0 값을 준다.   
   
Study.java 는 풀이 한 코드보다 더 괜찮은 코드라고 생각해서 따로 분석해보기 위해 올려두었다.