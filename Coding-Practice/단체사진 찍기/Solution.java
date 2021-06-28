class Solution {
	// name = 프렌즈 들의 이름이 들어간다.
	// position = 프렌즈들이 사진을 찍을때의 위치배열이다.
	// visited = DFS 순열, 방문했는지를 저장한다.
	// answer = 조건에 맞는 자리들의 카운트를 증가시켜 줄 것이다.
    char[] name = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    char[] position;
    boolean[] visited;
    int answer;

    public int solution(int n, String[] data) {
		// 전역변수를 초기화 시켜준다.
        answer = 0;
        position = new char[name.length];
        visited = new boolean[name.length];
		
		// 프렌즈들의 자리 정하기 시작 (dfs, 순열이다.)
        dfs(n, data, 0);
        return answer;
    }



    public void dfs(int n, String[] data, int deep){
		// 모든 자리가 다 정해졌다면, 문제에 주어진 조건에 맞는지 확인한다.
        if(deep == name.length){
            if(checkCondition(position, data, n))
				// 조건까지 맞다면 가능한 자리 종류의 개수를 증가시켜준다.
                answer++;
            return ;
        }
		
		// 자리가 모두 정해지지 않았다면, 자리를 정해준다.
        for(int i=0;i<name.length;i++){
            if(!visited[i]){
				// 방문하지 않았다면, 방문 후 방문했다는 흔적을 남겨준 후,
                visited[i] = true;
				// 자리[position]에 프렌즈[name]를 세운다.
                position[deep] = name[i];
				// 그 후 다음 자리에 넣어 줄 프렌즈를 또 찾는다.
                dfs(n, data, deep+1);
				// 모두 방문 후, 다른 방법으로 프렌즈들을 세울 수 있는 방법을 더 찾기 위해 방문사실을 없애준다.
                visited[i] = false;
            }
        }
    }

	// 모든 자리가 정해진 후, 문제에 주어진 조건에 맞는 자리인지 확인
    public boolean checkCondition(char[] position, String[] data, int n){
		// a = 조건에 있는 첫번째 프렌즈
		// b = 조건에 있는 두번째 프렌즈
		// a_idx = a 프렌즈가 서 있는 자리 번호
		// b_idx = b 프렌즈가 서 있는 자리 번호
		// compare = 부등호 (= < >)
		// condition = a, b 프렌즈가 얼마나 가까이, 혹은 멀리 있고싶어하는지의 거리
        for(int i=0;i<n;i++){
            char a = data[i].charAt(0);
            char b = data[i].charAt(2);
            int a_idx=-1, b_idx=-1;
            char compare = data[i].charAt(3);
            int condition = data[i].charAt(4)-'0';
			
			// a, b 프렌즈의 각 자리를 찾고, 찾은 자리의 번호는 a_idx, b_idx 에 넣어준다.
            for(int j=0;j<position.length;j++){
                if(position[j] == a) a_idx = j;
                if(position[j] == b) b_idx = j;
                if(a_idx != -1 && b_idx != -1) break;
            }
			
			// gap = a, b 프렌즈 사이의 거리. -1 을 한 이유는, a, b가 만약 서로 인접하고 싶은 경우라면 0이기 때문이다
			// 그냥 a, b 프렌즈 사이에 또 다른 프렌즈들이 얼마나 있는가를 나타낸다.
            int gap = Math.abs(a_idx - b_idx)-1;
			// 조건에 맞지 않다면 문제 내 조건에 맞지 않는 자리에 서 있으므로 false 리턴
            switch(compare){
                case '=' :
                    if(gap != condition) return false;
                    break;
                case '<' :
                    if(gap >= condition) return false;
                    break;
                case '>' :
                    if(gap <= condition) return false;
                    break;
            }
        }
		// 조건에 맞는 자리에 서 있다면 true
        return true;
    }

}