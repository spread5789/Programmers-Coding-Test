class Solution {
    public int[] solution(int brown, int yellow) {
        int h=0;
        int w=(int)Math.sqrt(brown);

        for(;w<=brown/2;w++){
            h = (brown+yellow)/w;
            if(w<h) continue;
            if(brown + yellow == w*h) break;
        }

        return new int[] {w,h};
    }
}