class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        char [] letters = s.toCharArray();
        
        if(letters.length!=4&&letters.length!=6){
            answer = false;
            return answer;
            
        }
        
        for(int l =0; l<letters.length; l++){
            if((int)letters[l]>=65){
              answer= false;
                break;                
            }
        }
        return answer;
    }
}