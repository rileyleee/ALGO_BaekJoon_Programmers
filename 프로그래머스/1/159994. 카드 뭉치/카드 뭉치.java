import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        Deque<String> one = new ArrayDeque<>();
        Deque<String> two = new ArrayDeque<>();
        
        for(String i : cards1) one.addLast(i);
        for(String i : cards2) two.addLast(i);
        
        boolean impossible = false;
        
        for(String i : goal){
            if(!one.isEmpty() && one.peekFirst().equals(i)){
                one.pollFirst();
            }else if(!two.isEmpty() && two.peekFirst().equals(i)){
                two.pollFirst();
            }else{
                impossible = true;
            }
            
            if(impossible) break;           
                
        }
        
        answer = impossible? "No" : "Yes";
    
        
        return answer;
    }
}