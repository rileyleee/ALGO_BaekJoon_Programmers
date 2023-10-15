import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        
        int max = Math.max(n,m);
        int min = Math.min(n,m);
        
        while(min!=0){ // max => 최소공배수가 됨
            int r = max%min;
            max = min;
            min = r;
        }
        
        int minMul = n*m/max;
        int[] answer = {max, minMul};
        return answer;
    }
}