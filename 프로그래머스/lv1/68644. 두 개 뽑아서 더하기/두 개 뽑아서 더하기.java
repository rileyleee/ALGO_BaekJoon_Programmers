import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {       

        int [] temp = new int[201];
        
        for(int i =0; i<numbers.length; i++){
            for(int j =i+1; j<numbers.length; j++){
                temp[numbers[i]+numbers[j]]++;
                System.out.println(numbers[i]+numbers[j]);
            }
        }
        
        int cnt = 0;
        for(int i=0; i<temp.length; i++){
            if(temp[i]!=0){
                cnt++;                                                
            }
        }
        
        int[] answer = new int[cnt];
        int j =0;
        for(int i=0; i<temp.length; i++){
            if(temp[i]!=0){
                answer[j] = i;
                j++;
            }
        }
        Arrays.sort(answer);  
        
        return answer;
    }
}