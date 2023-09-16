class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        
        int total = brown+yellow;
        
        for(int i = total; i>=3; i--){
            if(total%i==0){
                int row = total/i;
                int col = i;
                
                if((row*2+col*2-4)==brown){
                    answer[0] = row;
                    answer[1] = col;
                }
            }
            
        }
        
        return answer;
    }
}