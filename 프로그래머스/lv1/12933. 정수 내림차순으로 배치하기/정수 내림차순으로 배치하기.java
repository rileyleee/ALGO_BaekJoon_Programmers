import java.util.*;

class Solution {
    public long solution(long n) {
        
        String str = String.valueOf(n);
        
        char[] letters = str.toCharArray();
        
        Arrays.sort(letters);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = letters.length-1; i >=0; i--){
            sb.append(letters[i]);
        }
 
        long answer = Long.parseLong(sb.toString());
        return answer;
    }
}