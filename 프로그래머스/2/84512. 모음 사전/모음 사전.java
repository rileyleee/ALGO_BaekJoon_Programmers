import java.util.*;
class Solution {
    public static char [] arr = {'A', 'E', 'I', 'O', 'U'};
    public static String target;
    public static int tmp, answer;
    public int solution(String word) {
        tmp = 0;
        answer = -1;
        target = word;
              
        StringBuilder sb = new StringBuilder();
        
        int length = sb.length();

        makeWords(sb, length);
        
        
        return answer;
    }
    
    public static void makeWords(StringBuilder sb, int currLength){
        
        if (sb.toString().equals(target)){
            answer = tmp;
            return;
        }

        if (currLength == 5) return;


        for (int i = 0; i < arr.length; i++) {
            if (answer != -1) {
                return;
            }
            //System.out.println("currLength: " + currLength);
            if(sb.length()>currLength) sb.deleteCharAt(currLength);
            sb.insert(currLength, arr[i]);
            //System.out.println("현재 문자열: " + sb);
            tmp++;
            //System.out.println("현재 수: " + tmp);
            makeWords(sb, currLength + 1);
        }
        sb.deleteCharAt(currLength);
    }
}