class Solution {
    char[] name = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    char[] position;
    boolean[] visited;
    int answer;
    
    public int solution(int n, String[] data) {
        
        answer = 0;
        position = new char[name.length];
        visited = new boolean[name.length];
            
        dfs(n, data, 0);
        return answer;
    }
    
    
    
    public void dfs(int n, String[] data, int deep){
        if(deep == name.length){
            if(checkCondition(position, data, n))
                answer++;
            return ;
        }
        
        for(int i=0;i<name.length;i++){
            if(!visited[i]){
                visited[i] = true;
                position[deep] = name[i];
                
                if(checkCondition(position, data, n))
                    dfs(n, data, deep+1);
                
                visited[i] = false;
            }
        }   
    }
    
    
    public boolean checkCondition(char[] position, String[] data, int n){
        for(int i=0;i<n;i++){
            char a = data[i].charAt(0);
            char b = data[i].charAt(2);
            int a_idx=-1, b_idx=-1;
            char compare = data[i].charAt(3);
            int condition = data[i].charAt(4)-'0';
            
            for(int j=0;j<n;j++){
                if(position[j] == a) a_idx = j;
                if(position[j] == b) b_idx = j;
            }
            
            int gap = Math.abs(a_idx - b_idx)-1;
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
        
        return true;
    }
    
}