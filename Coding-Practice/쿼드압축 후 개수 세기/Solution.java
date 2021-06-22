// 탐색 할 블럭의 크기가 1이라면 1인지 0인지 세어준다.
// 크기가 1이 아니라면, 탐색 후, 같은 요소만 있는지 확인한다.
// 같은 요소만 있지 않다면 4등분으로 나눈 후 모두 같은 지 확인한다.
// 같다면 0, 1 카운트를 증가시킨다.
// 같지않다면, 다시 4등분 후 재귀를 실행한다.

class Solution {
    int zero, one;
    
    public int[] solution(int[][] arr) {
        zero=0;
        one=0;
        quad(arr, arr.length, 0, 0);
        
        return new int[] {zero , one};
    }
    
    private void quad(int[][] table, int length,int x, int y){
        if(length==1){
            if(table[y][x]==0) zero++;
            else if(table[y][x]==1) one++;
            return ;
        }
        // 같은 요소라면 더 나눌 필요가 없으니 끝.
        if(check(table,length, x, y)) return ;
        
        // 4개로 나눈 후, 각 사각형들을 다시 탐색
        length/=2;
        quad(table,length,x,       y);
        quad(table,length,x+length,y);
        quad(table,length,x,       y+length);
        quad(table,length,x+length,y+length);
        
    }
    // 같은 요소인지 체크
    private boolean check(int[][] table, int length, int x, int y){
        // 첫번째 값
        int value = table[y][x];
        
        // 검사중, 같지 않다면 false 반환
        for(int i=y;i<y+length;i++)
            for(int j=x;j<x+length;j++){
                if(table[i][j]!=value) return false;
            }
        // 같다면 요소가 무엇인지 체크 후 카운트 증가
        if(value==1) one++;
        else zero++;
        
        return true;
    }
}