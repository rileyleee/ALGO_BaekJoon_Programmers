import java.util.*;

class Solution {
    public int solution(int n) {        
        int answer = 0;
        
        int [] Remaining = new int[n+1];
        
        Remaining[0] = 0;
        Remaining[1] = 1;
        
        for(int i=2; i<=n; i++){
            Remaining[i] = (Remaining[i-2]+Remaining[i-1]) % 1234567;           
        }
        
        answer = Remaining[n];
        return answer;
    }
}