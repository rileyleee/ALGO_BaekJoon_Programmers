import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        //System.out.println(Arrays.toString(participant));
        //System.out.println(Arrays.toString(completion));
                
        HashMap<Integer, String> completed = new HashMap<>();
        
        for(int i = 0; i< completion.length; i++) completed.put(i, completion[i]);        
        
        for(int i = 0; i< participant.length; i++){
            
            if(i == participant.length-1) {
                answer = participant[i]; 
                break;
            }
            
            if(completed.get(i).equals(participant[i])) completed.remove(i);
            else{
                answer = participant[i];
                break;
            }
        }
        
        return answer;
    }
}