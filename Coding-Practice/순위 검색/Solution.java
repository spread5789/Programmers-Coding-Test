// 프로그래머스 순위 검색 문제
// https://wellbell.tistory.com/104
//
// 이것 먼저 공부해보기
// https://velog.io/@courage331/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4Java-%EC%88%9C%EC%9C%84%EA%B2%80%EC%83%89#%EB%AC%B8%EC%A0%9C-%ED%92%80%EC%9D%B4

/*

map과 list, 이진 탐색을 통해서 풀수 있는 문제인데
map에 모든 경우의수를 저장합니다 <String, List> 형태
경우의 수는 dfs를 통해서도 가능하지만 저는 비트 연산자를 통해서 해결하였습니다.


없는 key값이면 리스트를 만들어서 넣고 해당 리스트에 점수를 추가하고
있는 key값이면 리스트에 해당 점수를 추가합니다.
(이 때 ""를 키값으로 하는 경우가 있는데 이는 조건이 없는 모든 경우입니다.)

그리고 map안에 있는 모든 리스트를 정렬해줍니다. - 이진 탐색을 위해서

이제 query를 순회하면서 처리를 해야하는데.
query로 들어오는 문자는 아래와 같습니다.
[
"java and backend and junior and pizza 100",
"python and frontend and senior and chicken 200",
"cpp and - and senior and pizza 250",
"- and backend and senior and - 150",
"- and - and - and chicken 100",
"- and - and - and - 150"
]
 
이를 replace와 split 등을 이용해서 아래와 같이 만들어 줍니다. 
javabackendjuniorpizza ,100
pythonfrontendseniorchicken , 200
cppseniorpizza, 250
backendsenior, 150
chicken 100
"", 150
이제 키값으로 map의 list를 가져오고
스코어 값을 이진탐색합니다.
이진탐색은 lower bound를 찾아야합니다.
lower bound로 찾지않는다면 중복되는 점수가 있는 경우 오답이 됩니다.
 
만약 이러한 리스트가 있을때
50 80 150 150 210 260 
 
150 이상을 찾는다면
4개가 나와야합니다.
 
150을 통해서 lower bound를 찾는다면 2가 나오게 되고 이를 리스트 사이즈에서 빼면
6 - 2 = 4로 나오게 됩니다.

*/

import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (String in : info) {
            String[] split = in.split(" ");
            int score = Integer.parseInt(split[4]);

            for (int i = 0; i < (1 << 4); i++) {
                StringBuilder key = new StringBuilder();
                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) > 0) key.append(split[j]);
                }
                map.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
            }
        }

        // Map 안에 List sorting
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()){
            entry.getValue().sort(null);
        }

        int[] answer = new int[query.length];
        for(int i = 0; i < query.length; i++) {
            String[] splits = query[i].replaceAll("-", "").replaceAll(" and ", "").split(" ");
            String key = splits[0];
            int score = Integer.parseInt(splits[1]);
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            int start = 0;
            int end = list.size();
            // lower bound 를 구해야 함
            while (start < end) {
                int mid = (start + end) / 2;
                if(list.get(mid) < score) {
                    start = mid + 1;
                }else {
                    end = mid;
                }
            }
            // 전체에서 lower bound를 빼면 score와 같거나 큰 경우의 수
            answer[i] = list.size() - start;
        }
        return answer;
    }
}