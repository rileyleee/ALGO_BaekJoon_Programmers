import java.util.*;

class Solution {
    public String solution(String my_string) {
        
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<my_string.length(); i++){
            String c = my_string.substring(i,i+1); 
            if(c.charAt(0)>96) sb.append(c.toUpperCase());
            else sb.append(c.toLowerCase());
        }
        
        
        
        return sb.toString();
    }
}