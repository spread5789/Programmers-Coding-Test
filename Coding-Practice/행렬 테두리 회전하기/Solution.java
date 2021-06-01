import java.util.*;

class Solution {
    int[][] nums;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        // 배열 선언
        nums = new int[rows][columns];
        int[] answer = new int[queries.length];
        
        // 배열 초기화
        for(int i=1;i<=rows;i++)
            for(int j=1;j<=columns;j++){
                nums[i-1][j-1] = (i-1) * columns + j;
            }
        
        // 회전시키기
        for(int i=0;i<queries.length;i++)
            answer[i] = rotate(queries[i]);
        
        return answer;
    }
    
	// 회전 메서드
    public int rotate(int[] queries){
        int x1 = queries[1]-1;
        int x2 = queries[3]-1;
        int y1 = queries[0]-1;
        int y2 = queries[2]-1;
        
        int min = nums[y1][x1];
        int temp = nums[y1][x1];
        
        for(int i=y1;i<y2;i++){ // 좌측 변 회전
            nums[i][x1] = nums[i+1][x1];
            if(nums[i][x1] < min) min = nums[i][x1];
        }
        for(int i=x1;i<x2;i++){ // 하단 변 회전
            nums[y2][i] = nums[y2][i+1];
            if(nums[y2][i] < min) min = nums[y2][i];
        }
        for(int i=y2;i>y1;i--){ // 우측 변 회전
            nums[i][x2] = nums[i-1][x2];
            if(nums[i][x2] < min) min = nums[i][x2];
        }
        for(int i=x2;i>x1+1;i--){ // 상단 변 회전
            nums[y1][i] = nums[y1][i-1];
            if(nums[y1][i] < min) min = nums[y1][i];
        }
        nums[y1][x1+1] = temp;
        
        return min;
    }
}