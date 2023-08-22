class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int zeroCnt = 0;
        int matchCnt = 0;
        
        for(int i = 0; i < lottos.length; i++){
            
            if(lottos[i] == 0){
                zeroCnt++;
            }
            
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    win_nums[j] = -1;
                    matchCnt++;
                }
            }            
        }
        
        int worstNum = matchCnt;
        int bestNum = matchCnt + zeroCnt;
    
        
        int[] answer = {change(bestNum), change(worstNum)};
        return answer;
    }
    
    public int change(int Num){
        switch(Num){
            case 6 : 
                return 1;
            case 5 : 
                return 2;
            case 4 : 
                return 3;
            case 3 : 
                return 4;
            case 2 : 
                return 5;
            default:
                return 6;
        }
    }
}