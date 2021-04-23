문제
==
![1](https://user-images.githubusercontent.com/73854324/115923503-4a74b680-a4b9-11eb-8c81-38e5179b9240.PNG)

<br><br>
회고
==
쉬운문제다.
길이가 8인 "abcdefgh" 문자가 들어올 경우에는   
3,4 인덱스의 문자를 반환해야하고, (substring(3,5))   
   
길이가 7인 "abcdefg" 문자가 들어올 경우에는   
3 인덱스의 문자를 반환해야한다. (substring(3,4))   
   
```
s.substring( (s.length()-1) / 2 , s.length()/2 +1 );
```
한 줄이면 7/2 = 3 처럼 소수점이 버려지는것을 이용하여 원하는 문자열들의 인덱스를 뽑아낼 수 있다.   
처음에는 문자가 1개만 들어올 경우를 생각해서   
```
if(s.length() == 1 || s.length() == 2) return s;
s = s.substring( (s.length()-1) / 2 , s.length()/2 +1 );
```
이렇게 작성했는데 인덱스 범위를 벗어나도 오류가 나지 않았다.

## 전체 코드
```
class Solution {
    public String solution(String s) {
         return s = s.substring((s.length()-1)/2,s.length()/2+1);
    }
}
```