// 첫번째 사람을 선택한다.
// 이미 탔다면 넘어간다
// 두번째 사람을 선택한다.
// 이미 탔다면 넘어간다.
// 두 사람이 모두 타지 않은 상태라면 더해서 무게를 비교한다.
// 무게가 제한을 넘지 않는다면 두 사람 모두 태운다.
// 무게가 제한을 넘었다면, 두번째 사람을 다시 선택한다.
// 두번째 사람을 모두 탐색했는데도 만족하지 않다면, 첫번째 사람만 혼자 태운다.

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int j=0;
        boolean[] check = new boolean[people.length];
        for(int i=0;i<check.length;i++)
            check[i] = false;
        
        
        for(int i=0;i<people.length;i++){
            if(check[i]==true) continue;
            
            for(j=i+1;j<people.length;j++){
                if(check[j]==true) continue;
                
                if(people[i]+people[j]<=limit){
                    check[i]=true;
                    check[j]=true;
                    answer++;
                    break;
                }else continue;
            }
            if(j==people.length){
                check[i]=true;
                answer++;
            }
            
        }
        
        return answer;
    }
}