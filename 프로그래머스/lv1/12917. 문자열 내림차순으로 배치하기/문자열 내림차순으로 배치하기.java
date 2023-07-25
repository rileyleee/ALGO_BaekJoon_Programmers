import java.util.*;

class Solution {
    public String solution(String s) {
        
        char[] letter = s.toCharArray();
        
        int[] letterNum = new int[letter.length];
        
        for(int i = 0; i < letter.length; i++){            
            letterNum[i] = letter[i] - 0;                    
        }
        
        Arrays.sort(letterNum);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = letterNum.length-1; i>=0; i--){
            sb.append((char)letterNum[i]);
            
        }
        
        
        String answer = sb.toString();
        return answer;
    }
}