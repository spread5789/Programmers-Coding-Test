문제
==
![캡처](https://user-images.githubusercontent.com/73854324/115925140-a3454e80-a4bb-11eb-8151-1f78c2e1909d.PNG)

<br><br>
   
==
   
대부분 내가 작성한 코드와 유사한 방식대로 풀었었다. 그 만큼 답이 명확하고 쉬운 문제이다.   
PreNum 이라는 변수를 따로 선언해서 이전 정수를 저장해줌으로써, 첫 값을 넣어주지 않는 코드도 있었다.   
내 코드보다 깔끔한 코드였고, 이런 세세한 부분들에서 차이가 난다는 것에서 더 노력해야겠다는 생각이 들었다.   
그 코드도 하단에 올려보도록 하겠다.   

```
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = 10;
        for(int num : arr) {
            if(preNum != num)
                tempList.add(num);
            preNum = num;
        }       
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }
        return answer;
    }
}
```