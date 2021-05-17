class Solution {
    public boolean solution(int x) {
        // 입력받은 x를 각 자리별로 배열에 담기
        String[] num = Integer.toString(x).split("");
        int sum = 0;
        
        // 각 숫자들 더해주기
        for(int i=0;i<num.length;i++)
            sum += Integer.parseInt(num[i]);
        
		// 하샤드 수 조건
        if(x%sum==0)
            return true;
        
        return false;
    }
}