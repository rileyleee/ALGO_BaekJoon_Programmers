import java.util.*;

class Solution {
    public String solution(String s) {
        
        
        String[] nums = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            if(max<Integer.parseInt(nums[i])){
                max = Integer.parseInt(nums[i]);
            }
            
            if(min>Integer.parseInt(nums[i])){
                min = Integer.parseInt(nums[i]);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(min).append(" ").append(max);
        
        String answer = sb.toString();
        return answer;
    }
}