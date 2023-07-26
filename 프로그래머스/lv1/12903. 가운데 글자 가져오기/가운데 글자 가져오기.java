import java.util.*;

class Solution {
    public String solution(String s) {
        
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        
        char[] letter = s.toCharArray();
        
        int midIdx = length/2-1;
        
        if(length%2!=0){
            answer = Character.toString(letter[midIdx+1]);
        }else{
            sb.append(letter[midIdx]).append(letter[midIdx+1]);
            answer = sb.toString();
        }
        
        return answer;
    }
}