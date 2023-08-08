import java.util.*;

public class Solution {
    public int solution(int n) {
        
        String stringN = Integer.toString(n);
        
        char[] letters = stringN.toCharArray();
            
        int answer = 0;
        
        for(int i = 0; i < letters.length; i++){
            answer+=letters[i]-48;
        }

        return answer;
    }
}