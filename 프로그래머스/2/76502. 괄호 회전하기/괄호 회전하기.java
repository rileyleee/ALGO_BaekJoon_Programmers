import java.util.*;


class Solution {
    public int solution(String s) {
        
        int ans = 0;
        
        HashMap<Character, Character> map = new HashMap<>();
        
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        
        int len = s.length();
        s+=s;
        
        A: for(int i = 0; i<len; i++){
            
            Deque<Character> stk = new ArrayDeque<>();
            
            for(int j = i; j<i+len; j++){
                char thisLetter = s.charAt(j);
                
                if(map.containsKey(thisLetter)) stk.push(thisLetter);
                if(!map.containsKey(thisLetter) && stk.isEmpty()) continue A;
                if(!stk.isEmpty() && thisLetter == map.get(stk.peek())) stk.pop();
                
            }
            
            if (stk.isEmpty()) ans++;
            
        }
        
        return ans;
    }
}