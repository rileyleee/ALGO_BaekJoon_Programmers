import java.util.*;

class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        
        // 숫자 0: 45 대문자A: 68  소문자a: 97        
        for(int i = 0; i<s.length(); i++){
            
            //System.out.println(s.charAt(i)-0);
            
            if(i==0){
                if(s.charAt(i)>=97){
                    sb.append(Character.toChars(s.charAt(i)-32));
                }else{
                    sb.append(s.charAt(i));
                }
            }
            
            if(i>0){
                if(s.charAt(i-1)==' '&&s.charAt(i)!=' '){
                    if(s.charAt(i)>=97){
                        sb.append(Character.toChars(s.charAt(i)-32));
                    }else{
                        sb.append(s.charAt(i));
                    }
                }else{
                    sb.append(s.charAt(i));
                }
            }
            
        }
        String answer = sb.toString();
        return answer;
    }
}