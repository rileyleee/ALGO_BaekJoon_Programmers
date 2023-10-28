class Solution {
    public long solution(int n) {
        
        int num = 1234567;
        
        long [] dp = new long[2001];
        
        dp[1] = 1;
        dp[2] = 2;        
        
        
        if(n>=3){            
            for(int i = 3; i<=n; i++) {
                dp[i] = (dp[i-1]+ dp[i-2])%num;
            }
        }
        
            
        long answer = dp[n];
        return answer;
    }
}