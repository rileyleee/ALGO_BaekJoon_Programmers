import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
            
        int len = answer.length;
        
        Deque<Integer> stk = new ArrayDeque<>();
        
        for(int i = 0; i < len; i++){
                        
            if(stk.isEmpty() || (!stk.isEmpty() && prices[stk.peek()] <= prices[i])) {                
                stk.push(i);
            }
            else{
                while(!stk.isEmpty() && prices[stk.peek()] > prices[i]) {
                    answer[stk.peek()] = i - stk.pop(); //현재 넣으려고 하는 인덱스와 비교해서 거리를 넣기
                }
                stk.push(i);
            }
        }
        
        if(!stk.isEmpty()) {
            while(!stk.isEmpty()) {
                answer[stk.peek()] = (len-1)-stk.pop();
                }
        }

       
        return answer;
    }
}