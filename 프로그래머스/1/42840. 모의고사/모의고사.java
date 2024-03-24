import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int [] st1 = {1,2,3,4,5};
        int [] st2 = {2,1,2,3,2,4,2,5};        
        int [] st3 = {3,3,1,1,2,2,4,4,5,5};
        
        int cor1 = 0;
        int cor2 = 0;
        int cor3 = 0;
        
        
        for(int i =0; i<answers.length; i++){
            
            if(answers[i] == st1[i % 5]) cor1++;
            if(answers[i] == st2[i % 8]) cor2++;
            if(answers[i] == st3[i % 10]) cor3++;
            
        }
        
        int highest = Math.max(cor1, Math.max(cor2, cor3));
        
        List<Integer> list = new ArrayList<>();
        
        
        if(cor1 == highest) list.add(1);
        if(cor2 == highest) list.add(2);
        if(cor3 == highest) list.add(3);      
               
        int [] answer = new int [list.size()];
        
        for(int i =0; i<list.size(); i++) answer[i] = list.get(i);
        
        return answer;
    }
}