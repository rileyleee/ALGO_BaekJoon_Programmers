import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);     
        
        //System.out.println(Arrays.toString(d));
        
        
        for(int i : d){
            int tmp = budget;
            //System.out.printf("tmp는 %d\n",tmp);
            
            if(tmp-i>=0){
                budget=tmp-i;
                answer++;
            }
        }
        
        
        
        return answer;
    }
}