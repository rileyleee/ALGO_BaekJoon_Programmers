import java.util.*;

class Solution {
    
    public String solution(int n) {    
        
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            int remainder = (n) % 3;
            
            if(remainder == 0) 
                sb.insert(0, "4");
            else if(remainder == 1) 
                sb.insert(0, "1");
            else if(remainder == 2) 
                sb.insert(0, "2");
            
            n = (n - 1) / 3;
        }
        
        return sb.toString();
    }  
}
