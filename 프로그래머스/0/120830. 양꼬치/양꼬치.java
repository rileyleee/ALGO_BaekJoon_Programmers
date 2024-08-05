class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        answer+= n*12000 + k*2000;
        
        int service = n/10;
        
        answer-=service*2000;
        
        return answer;
    }
}