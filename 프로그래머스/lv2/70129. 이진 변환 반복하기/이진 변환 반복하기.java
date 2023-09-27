import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int BiCnt =0;
        int cnt = 0;
        
        while(!s.equals("1")){
            BiCnt++;
            
            int originlength = s.length();
            
            s= s.replace("0","");
            
            int afterlength = s.length();
            
            cnt += (originlength-afterlength);
        

            s = Integer.toBinaryString(afterlength);
            
        }        
        
        int[] answer = new int[2];
        answer[0] = BiCnt;
        answer[1] = cnt;
        return answer;
    }
}