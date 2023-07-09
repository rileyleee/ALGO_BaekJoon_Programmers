class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int totalD = 0;
        int totalP = 0;
        
        for(int d = n-1; d >= 0; d--){            
            totalD += deliveries[d];
            totalP += pickups[d];
            
            while(totalD > 0 || totalP > 0){ 
                //특정 지점에서 배달/수거 용량이 남은 경우 총 일의 양이 음수임
                //그래서 이 while문에 들어오지 않고 거리값도 더해지지 않음
                totalD -= cap;
                totalP -= cap;
                answer += (d+1)*2;
            }
        }      
        
        return answer;
    }
}