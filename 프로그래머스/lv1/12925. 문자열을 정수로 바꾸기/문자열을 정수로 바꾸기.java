import java.util.*;

class Solution {
    
    public int solution(String s) {
        
        char pm = s.charAt(0);
        int answer = Integer.parseInt(s.substring(1));  
        
        if (pm !='-'){
            answer = Integer.parseInt(s.substring(0));  
            return answer;
        }else{            
            return 0-answer;
        }
    }
}