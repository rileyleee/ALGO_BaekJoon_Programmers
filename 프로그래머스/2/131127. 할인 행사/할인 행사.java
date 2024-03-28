import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int len = discount.length;
        
        boolean nextDay;
        
        for(int i = 0; i <= len-10; i++){
            
            nextDay = false;
            HashMap<String, Integer> possible = new HashMap<>();
            
            for(int j = i; j< i+10; j++){
                possible.put(discount[j], possible.getOrDefault(discount[j], 0) +1);
            }
            
            // 원하는 만큼 획득하는지 확인            
            for(int k = 0; k < want.length; k++){                
                if(!possible.containsKey(want[k]) || 
                   possible.get(want[k]) < number[k]) nextDay = true;
            }
            
            if(!nextDay) answer++;
        
        }
        return answer;
    }
}