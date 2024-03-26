import java.util.*;

class Solution {
    boolean solution(String s) {

        char [] str = s.toCharArray();
        
        Deque<Character> stk = new ArrayDeque<>();
        
        for(char i : str){
            
            if(i == '(') stk.push(i);
            else{
                if(!stk.isEmpty() && stk.peek()=='(') stk.pop();
                else return false;
            }
                       
        }    
        return stk.isEmpty();
    }
}