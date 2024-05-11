class Solution {
    public int solution(int storey) {
        int answer = 0;
        int tmp = 0;
        while(storey!=0){
            tmp = storey%10;
            
            if(tmp >= 6){
                storey+=10-tmp;
                answer+=10-tmp;
                
            }else if(tmp==5 && (storey/10) % 10 >= 5) {
                storey+=10-tmp;
                answer+=10-tmp;
                
            }else answer+=tmp;
                 
            storey= storey/10;
             
        }
        return answer;
    }
}