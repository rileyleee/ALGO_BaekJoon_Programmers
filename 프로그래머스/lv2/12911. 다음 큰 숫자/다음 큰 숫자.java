import java.util.*;

class Solution {
    public int solution(int n) {
        
        int answer = 0;        
        int num = n;
        
        int oneCnt =  0;
        
        while(num != 0){
            if(num%2==1){
                oneCnt++;
            }
            num = num/2;            
        }
        
        for(int i = n+1; i <= 1000000; i++){
            
            int thisOneCnt = 0;
            int thisNum = i;
            
            while(thisNum!=0){
                
                if(thisNum%2 == 1){
                    thisOneCnt++;
                }
                
                thisNum = thisNum/2;
            }
            
            if(oneCnt == thisOneCnt){
                answer = i;
                break;
            }
            
        }
        return answer;
    }
}