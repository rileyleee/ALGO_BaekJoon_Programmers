import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> stkF = new Stack<>();
        
        char[] chk = s.toCharArray();
        
         boolean answer = true;
        
        for(int i =0; i<chk.length; i++){
            if(i ==0){
                if( chk[i] =='('){
                    stkF.push(chk[i]);
                }else{
                    answer =false;
                    break;
                }
            }else{
                if(chk[i]=='('){
                    stkF.push(chk[i]);
                }else{
                    if(!stkF.isEmpty()){
                        stkF.pop();
                    }else{
                        answer = false;
                        break;
                    }
                }
            }
        }
        
        if(!stkF.isEmpty()){
            answer = false;
        }
        return answer;
    }
}