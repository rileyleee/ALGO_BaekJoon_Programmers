import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        
        String[] each = numbers.split("");
        
        int [] numCnt = new int [10];
        
        for(String s : each)            
            numCnt[Integer.parseInt(s)]++;
        
        for(int i = 2; i<10000000; i++){
            
            if(isPrimeNum(i) && isPossible(numCnt, i)) answer++;
        }
            
        
        return answer;
    }
    
    private static boolean isPrimeNum(int target){
        
        for(int i = 2; i <= Math.sqrt(target); i++){
            if(target%i==0) return false;
        }
        
        return true;
    }
    
    private static boolean isPossible(int[] pool, int target){
        
        int[] temp = pool.clone();
        
        
        while(target>0){
            
            
            if(temp[target%10] == 0) return false;
            
            temp[target%10]--;
            
            target/=10;
            
        }
        
        return true;
        
        
        
    }
}





