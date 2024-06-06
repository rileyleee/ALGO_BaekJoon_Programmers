

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int a = 0;
        int b = 0;        
     
        
        for(int i = 0;i<sizes.length; i++){
            
            a = Math.max(a, Math.max(sizes[i][0], sizes[i][1]));
            b = Math.max(b, Math.min(sizes[i][0], sizes[i][1]));

        }
        

        answer =  a*b;
        
        
        return answer;
    }
}