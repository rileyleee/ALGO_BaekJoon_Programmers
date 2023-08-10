import java.util.*;

class Solution {
    
    public String solution(String phone_number) {
        
        char[] numbers = phone_number.toCharArray();
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i = numbers.length-1; i >= 0; i--){
            j++;
            if(j<5){
                sb.append(numbers[i]);
            }
            else{
                sb.append("*");
            }
        }
        
        // System.out.println(sb.reverse().toString());
        String answer = sb.reverse().toString();
        return answer;
    }
}