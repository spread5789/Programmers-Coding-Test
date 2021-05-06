class Solution {
    
    // 왼/오른손 마지막 위치 10=* 0=0 11=#
    int lPos = 10;
    int rPos = 12;
    
    /*
        각 좌표 알아내는 법
        x = (number-1) / 3
        y = (number-1) % 3
    */
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        for(int num : numbers){
            // 1, 4, 7 왼손
            if(num == 1 || num == 4 || num == 7){
                lPos = num;
                sb.append("L");
            }
            // 3, 6, 9 오른손
            else if(num == 3 || num == 6 || num == 9){
                rPos = num;
                sb.append("R");
            }
            // 2, 5, 8, 0 (*, # 은 numbers 에 입력되지 않음)
            else{
                int lLength = getLength(lPos,num);
                int rLength = getLength(rPos,num);
                
                // 거리가 가까운 손으로 입력
                if(lLength > rLength){
                    rPos = num;
                    sb.append("R");
                } else if(lLength < rLength){
                    lPos = num;
                    sb.append("L");
                }
                // 같다면 hand 값을 이용
                else{
                    if(hand.equals("left")){
                        lPos = num;
                        sb.append("L");
                    }else{
                        rPos = num;
                        sb.append("R");
                    }
                }
                
            }
            
        }
        
        return sb.toString();
    }
    
	// 거리를 찾아내는 메소드
    public int getLength(int pos, int num){
        if(num==0) num = 11;
        if(pos==0) pos = 11;
        
        int posX = (pos-1) / 3;
        int posY = (pos-1) % 3;
        
        int numX = (num-1) / 3;
        int numY = (num-1) % 3;
            
        return Math.abs(posX-numX) + Math.abs(posY-numY);
    }
}