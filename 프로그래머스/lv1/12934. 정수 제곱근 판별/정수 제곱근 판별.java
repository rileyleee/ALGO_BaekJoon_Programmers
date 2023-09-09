class Solution {
    public long solution(long n) {
        long answer = -1;

        if(Math.sqrt(n) % 1 == 0){
            long now = (long) Math.sqrt(n);
            answer = (now+1)*(now+1);
        }
        return answer;
    }
}