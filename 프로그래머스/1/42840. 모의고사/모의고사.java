import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int [] st1 = {1,2,3,4,5};
        int [] st2 = {2,1,2,3,2,4,2,5};        
        int [] st3 = {3,3,1,1,2,2,4,4,5,5};
        
        int [] cnt = new int [3];
        
        for(int i =0; i<answers.length; i++){
            
            if(answers[i] == st1[i % 5]) cnt[0]++;
            if(answers[i] == st2[i % 8]) cnt[1]++;
            if(answers[i] == st3[i % 10]) cnt[2]++;
            
        }
        
        int highest = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < 3; i++) {
            if(cnt[i] == highest) list.add(i+1);
        }       
        
        int [] answer = new int [list.size()];
        
        for(int i =0; i<list.size(); i++) answer[i] = list.get(i);
        
        return answer;
    }
}