import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
		// 가장 긴 시간의 노래를 판별하기 위한 max 변수
        int max=0;
        String answer = "(None)";
        m = formatting(m);
        
        for(int i=0;i<musicinfos.length;i++){
            String[] music = musicinfos[i].split(",");
            music[3] = formatting(music[3]);
            
            String[] start = music[0].split(":");
            String[] end = music[1].split(":");
            
            int hour = ( Integer.parseInt(end[0]) - Integer.parseInt(start[0]) ) *60 ;
            int len = hour + Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
            
            StringBuilder melody = new StringBuilder();
            for(int j=0;j<=len;j++){
                melody.append(music[3].charAt(j%music[3].length()));
            }
            if(melody.toString().contains(m)){
                if(max < melody.toString().length()){
                    max = melody.toString().length();
                    answer = music[2];
                }
            }
        }
        
        
        return answer;
    }
    
	// #이 달린 음 일경우, 소문자로 치환
    private String formatting(String a){
        return a.replaceAll("C#","c").replaceAll("D#","d").replaceAll("F#","f").replaceAll("G#","g").replaceAll("A#","a");
    }
}