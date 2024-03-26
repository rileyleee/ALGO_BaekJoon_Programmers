import java.util.*;


class Solution {
    public int solution(String s) {
        
        char[] target = s.toCharArray();
        
        Deque<Character> base = new ArrayDeque<>();
        
        for(int i = 0; i<target.length; i++){
            base.push(target[i]);
        }
        
        int ans = 0;
        
        for(int i = 0; i<target.length; i++){
            
            if(i >= 1) base.push(base.pollLast());
            
            Deque<Character> tmp = new ArrayDeque<>(base);
            
            Deque<Character> stk = new ArrayDeque<>();
            
            boolean impossible = false;
            
            while(!tmp.isEmpty()){
                char thisLetter = tmp.pollLast();
                //System.out.println("이번 letter: "+ thisLetter);
                
                if(stk.isEmpty()&&((thisLetter == ')')||(thisLetter == '}')||(thisLetter == ']'))) {
                    //System.out.println("비어있고 닫는 괄호야");
                    impossible = true;
                    break;
                }
                
                if((!stk.isEmpty() && stk.peek()=='(' && thisLetter==')')||
                   (!stk.isEmpty() && stk.peek()=='{' && thisLetter=='}')||
                   (!stk.isEmpty() && stk.peek()=='[' && thisLetter==']')) {
                    //System.out.println("짝궁만나서pop");
                    stk.pop();                    
                }
                
                else {
                    //System.out.println("넣었어");
                    stk.push(thisLetter);
                }
            }  
            
            if(!impossible && stk.isEmpty()) ans++;
            
        }   
        
        return ans;
        
    }
}