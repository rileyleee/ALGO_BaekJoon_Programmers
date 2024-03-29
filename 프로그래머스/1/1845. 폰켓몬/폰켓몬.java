import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer, Integer> mon = new HashMap<>();
        
        for(int i : nums){
            mon.put(i, mon.getOrDefault(i, 0)+1);
        }
        
        for(int i : mon.keySet()){
            if(mon.get(i)!=0) answer++;
            
            if(answer==nums.length/2) break;
            
        }
    
        
        return answer;
    }
}