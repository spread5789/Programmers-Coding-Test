class Solution {
    public String solution(int a, int b) {

        int temp=0;

        // 월 별 일 저장
        int[] day_count = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};

        // 입력된 월의 전월까지 몇일인지 계산
        for(int i=0;i<a-1;i++)
            temp+=day_count[i];

        // 총 일 수 합산 후 요일을 계산 (일주일은 7일)
        temp= (temp+b)%7;

        return day[temp];
    }
}