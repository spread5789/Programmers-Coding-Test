import java.util.*;

class Solution {
    // 옷의 종류 = 키
    // 옷의 개수 = 값 (옷의 이름은 필요없음)
    // 경우의 수..
    // 모자 3개, 상의 3개, 바지 3개.. 27개. 3*3*3
    public int solution(String[][] clothes) {
        int answer;
        HashMap<String, Integer> map = new HashMap<>();
        
        // 옷의 종류를 키로 넣는데,
        // 이미 같은 옷종류가 있다면 값을 +1을 해주고, 없다면 1 을 넣어준다.
        for(int i=0;i<clothes.length;i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
        
        
        // 옷의 종류가 1가지라면, 옷의 개수만 리턴해준다.
        if(map.size()==1){
            return clothes.length;
        }
        // 옷의 종류가 여러개라면, 만들 수 있는 조합의 개수를 구해준다.
        else{
            int sum = 1;
            // 옷이 여러 종류일 경우, 예를 들어 상의 2개, 바지 2개라면 입을 수 있는 종류는 2*2 이다.
            // 그러나 문제에서는 입지 않아도 될 경우도 있다.
            // 상의의 경우라면 (아무것도 입지않음)(A)(B) 이렇게 3 의상이 있다고 가정해야해서 +1 을 해줘야한다.
            for(String key : map.keySet()){
                sum = sum * (map.get(key)+1);
            }
            
            answer = sum;
        }
        
        // -1 을 해주는 이유는, 위 계산의 경우 모두 다 입지 않는 경우도 포함되어있는데,
        // 하나 이상의 옷을 입어야 하니 아무것도 입지 않은 경우의 수는 빼줘야한다.
        return answer-1;
    }
}