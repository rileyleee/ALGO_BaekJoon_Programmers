import java.util.*;

class Solution{
    public int solution(String s){
        int answer = 0;
        Stack<Integer> stk = new Stack<>();
        
        for(int i =0; i<s.length(); i++){
            int now = s.charAt(i)-48;
            if(!stk.isEmpty()&&stk.peek()==now){
                //System.out.println("이거 뺌: "+stk.peek());
                stk.pop();
                
                }else{
                //System.out.println("이거 더함: "+now);
                stk.push(now);
                
            }
        }
        if(stk.isEmpty()){
            answer = 1;
        }

        return answer;
    }
}