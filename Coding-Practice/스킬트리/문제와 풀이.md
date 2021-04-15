보통은 문제를 읽고 생각나는 접근방식이 있으면 그것부터 무작정 시도해보고   
틀리면 살짝만 바꿔보며.. 안될경우 싹 다 갈아엎기까지 한 적도 있다.   
   
그런데 이 문제는 접근방식조차 엄청 고민하게 만든 문제였다.   
그래서 이 문제의 코드는 따로 적지않고 이 곳에 함께 적으려 한다.   
   
   <br>
   
문제 먼저
==
![캡처](https://user-images.githubusercontent.com/73854324/114898588-34c61800-9e4d-11eb-8c2e-19e586bf5b9d.PNG)
   
게임을 좋아하는 사람들이라면 선행스킬이 무엇인지 다 알것이다.
   내가 작성한 코드는 이렇다.
   처음엔 주석 없이 올려보도록 하겠다.
```
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            String tree = skill_trees[i].replaceAll("[^" + skill + "]", "");
            if(tree.equals("") || ((tree.charAt(0) == skill.charAt(0) && skill.contains(tree))))
                answer++;
        }
        return answer;
    }
}
```
   
   접근방식에 대해 오래 생각한 만큼, 정말 짧은 코드가 나왔다.
   (개인적으로 가독성도 괜찮다고 생각한다..) 이해가 안된다면 다음 코드에 적혀있는 주석들도 함께 보자
   
```
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
		
			// 오른쪽부터 천천히 보자.
			// skill_trees[i], 즉 하나의 스킬트리를 정규표현식을 이용하여 추출한 결과를 tree 변수에 넣는 코드이다.
			// 입력받은 skill 변수가 가지고있는 각 글자들(스킬틀)이 포함되어있지 않은 문자(스킬트리)는 공백으로 없애버리는 것이다.
			// 예)선행스킬 : ABC , 스킬트리 : (BFTAC)  => tree : BAC
            String tree = skill_trees[i].replaceAll("[^" + skill + "]", "");
			
			// 1. 선행스킬에 들어있는 스킬들이 하나도 포함되어있지 않거나,
			// 2-1. 선행스킬의 첫글자와 tree 변수가 가지고 있는 첫글자가 같고,
			// 2-2. 선행스킬들의 문자가 tree 변수의 문자를 가지고 있을경우에만
            if(tree.equals("") || ((tree.charAt(0) == skill.charAt(0) && skill.contains(tree))))
                answer++;
        }
        return answer;
    }
}
```
   
   1번 조건이 없다면 이러한 스킬트리는 정답에 포함되지 않을것이다.(포함되어야 한다)
   ```
   선행 : ABC / 스킬트리 : DEF
   ```
   <br>
   2-1번 조건이 없다면 이러한 스킬트리들도 정답에 포함될 것이다.(포함되면 안된다)
   ```
   선행 : CDEF / 스킬트리 : EF
   ```
   <br>
   2-2번 조건이 없다면 이러한 스킬트리들도 정답에 포함될 것이다.(포함되면 안된다)
   ```
   선행 : CDEF / 스킬트리 : CFED
   ```