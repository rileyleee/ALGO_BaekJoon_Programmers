import java.util.*;

class Solution {
    public int solution(int left, int right) {
        
        int [] count = new int[right-left+1];
        
        for(int i = left; i <= right; i++){
            for(int j = 1; j <= i; j++){
                if(i%j==0){
                    count[i-left]++;
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 0; i<count.length; i++){
            if(count[i]%2==0){
                answer+=(i+left);
            }else{
                answer-=(i+left);
            }
        }
        
        return answer;
    }
}