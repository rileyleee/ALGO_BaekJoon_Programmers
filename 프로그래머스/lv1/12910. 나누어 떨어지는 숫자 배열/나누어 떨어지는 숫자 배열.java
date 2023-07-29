import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] tempAnswer = new int [arr.length];
        
        int count = 0;
        for(int a =0; a<arr.length; a++){
            
            if(arr[a]%divisor==0){
                count++;
                tempAnswer[a] = arr[a];   
            }
        }
        if(count == 0){
            int [] answer = {-1};
            Arrays.sort(answer);
            return answer;
            
        }else{
            int [] answer = new int[count];
            int i = 0;
            for(int a =0; a<tempAnswer.length; a++){
                if(tempAnswer[a]!=0){
                    answer[i] = tempAnswer[a];   
                    i++;
                }
                
            }
            Arrays.sort(answer);
            return answer;
        }
        
       
        
    
        
        
        
    }
}