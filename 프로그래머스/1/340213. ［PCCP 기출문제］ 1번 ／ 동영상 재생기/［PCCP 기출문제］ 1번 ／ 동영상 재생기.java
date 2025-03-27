class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoSec = 60 * Integer.parseInt(video_len.substring(0,2)) + Integer.parseInt(video_len.substring(3,5));
        int posSec = 60 * Integer.parseInt(pos.substring(0,2)) + Integer.parseInt(pos.substring(3,5));
        int startSec = 60 * Integer.parseInt(op_start.substring(0,2)) + Integer.parseInt(op_start.substring(3,5));
        int endSec = 60 * Integer.parseInt(op_end.substring(0,2)) + Integer.parseInt(op_end.substring(3,5));
        
        for(String cmd : commands){
            if(startSec <= posSec && posSec <= endSec){
                posSec = endSec;
            }

            if(cmd.equals("next")){
                posSec += 10;
                if(videoSec-posSec<10){
                    posSec = videoSec;
                }
            }else{
                posSec -= 10;
                if(posSec<10){
                    posSec = 0;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if(startSec <= posSec && posSec <= endSec){
            return op_end;
        }else{
            int min = posSec/60;
            int sec = posSec%60;
            if(min<=10){
                sb.append("0");
            }
            sb.append(min + ":");
            
            if(sec<=10){
                sb.append("0");
            }
            
            sb.append(sec);
            String answer = sb.toString();
            return answer;
        }
    }
}