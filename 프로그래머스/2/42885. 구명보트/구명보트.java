import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        int answer = 0;
        
        Arrays.sort(people);
        
        int hIndex = people.length-1;
        int lIndex = 0;
        
        while(hIndex>=lIndex){
            
            if(hIndex==lIndex){
                answer++;
                break;
            }
            
            if(people[hIndex]+people[lIndex]<=limit){
                answer++;
                hIndex--;
                lIndex++;
            }else{
                answer++;
                hIndex--;
            }
        }
        
        return answer;
    }
}