class Solution {
    int ans;
    char[][] place;
    final static int[] x1 = {1,-1,0,0};
    final static int[] y1 = {0,0,1,-1};
    final static int[] x2 = {1,-1,1,-1};
    final static int[] y2 = {1,-1,-1,1};
    final static int[] x3 = {2,-2,0,0};
    final static int[] y3 = {0,0,2,-2};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
                place = new char[places.length][places[0].length];

        for(int z=0;z<places.length;z++){
            ans = 1;
            String[] temp = places[z];

            for(int i=0;i<places.length;i++){
                place[i] = temp[i].toCharArray();
            }

            for(int y=0;y<place.length;y++){
                for(int x=0;x<place[y].length;x++){
                    if(place[y][x]=='P'){
                        check(x,y);
                    }
                }
            }
            answer[z]=ans;
        }
        return answer;
    }

    private void check(int x, int y){
        for(int i=0;i<4;i++){
            int tx = x+x1[i];
            int ty = y+y1[i];
            if(tx < 0 || tx >= 5 || ty < 0 || ty >= 5) continue;
            else if(place[ty][tx] == 'P') ans = 0;
        }

        for(int i=0;i<4;i++){
            int tx = x+x2[i];
            int ty = y+y2[i];
            if(tx < 0 || tx >= 5 || ty < 0 || ty >= 5) continue;
            else if(place[ty][tx] == 'P') check_one(x, y, tx, ty);
        }

        for(int i=0;i<4;i++){
            int tx = x+x3[i];
            int ty = y+y3[i];
            if(tx < 0 || tx >= 5 || ty < 0 || ty >= 5) continue;
            else if(place[ty][tx] == 'P') check_two(x, y, tx, ty);
        }
    }

    private void check_one(int x, int y, int tx, int ty){
        int nx = x-tx;
        int ny = y-ty;

        if(nx == 1 && ny==1){
            if(place[y-1][x] != 'X' || place[y][x-1] != 'X') ans = 0;
        }else if(nx == 1 && ny == -1){
            if(place[y+1][x] !='X' || place[y][x-1] !='X') ans = 0;
        }else if(nx == -1 && ny == 1){
            if(place[y][x+1] != 'X' || place[y-1][x] != 'X') ans = 0;
        }else {
            if(place[y][x+1] != 'X' || place[y+1][x] != 'X') ans = 0;
        }
    }

    private void check_two(int x, int y, int tx, int ty){
        int nx = x-tx;
        int ny = y-ty;

        if(nx == -2 && ny==0){
            if(place[y][x+1] != 'X') ans = 0;
        }else if(nx == 2 && ny == 0){
            if(place[y][x-1] != 'X') ans = 0;
        }else if(nx == 0 && ny == -2){
            if(place[y+1][x] != 'X') ans = 0;
        }else {
            if(place[y-1][x] != 'X') ans = 0;
        }
    }
}