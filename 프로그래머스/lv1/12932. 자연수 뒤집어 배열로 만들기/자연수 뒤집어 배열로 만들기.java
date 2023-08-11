import java.util.*;
class Solution {
    public List<Integer> solution(long n) {
        List<Integer> answer = new ArrayList<>();
        
        String nStr = Long.toString(n);
        
        char[] letters = nStr.toCharArray();
        for(int i = letters.length-1; i>=0; i--){
            answer.add(letters[i]-48);
        }
        return answer;
    }
}