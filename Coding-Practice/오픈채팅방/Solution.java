import java.util.*;

// 리스트를 사용한 이유 : uid 의 개수가 가변적이기 때문
// HashMap을 사용한 이유 : 검색이 빨라서

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        // uid, 닉네임 매핑
        // 맵에 사용자의 uid와 가장 최근상태의 닉네임을 넣어줌
        for(int i=0;i<record.length;i++){
            String[] temp = record[i].split(" ");
            if(!temp[0].equals("Leave"))
                map.put(temp[1],temp[2]);
        }
        
        // 메시지 등록
        // 입장, 퇴장때만 메시지가 뜨므로 확인 후 리스트에 추가해준다.
        for(int i=0;i<record.length;i++){
            String[] temp = record[i].split(" ");
            if(temp[0].equals("Enter"))
                list.add(map.get(temp[1])+"님이 들어왔습니다.");
            else if(temp[0].equals("Leave"))
                list.add(map.get(temp[1])+"님이 나갔습니다.");
        }
        
        // 리스트를 배열에 옮겨줌.
        String[] answer = new String[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}