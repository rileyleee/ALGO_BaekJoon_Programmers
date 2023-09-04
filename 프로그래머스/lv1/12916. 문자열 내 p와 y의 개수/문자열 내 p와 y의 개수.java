class Solution {
    boolean solution(String s) {
        
        char[] letters = s.toCharArray();
        
        int cntP = 0;
        int cntY = 0;
        
        for(int i =0; i<letters.length; i++){
            if(letters[i]==('P')||letters[i]==('p')){
                cntP++;
            }else if(letters[i]==('y')||letters[i]==('Y')){
                cntY++;
            }
        }
        
        // System.out.println("P: "+cntP);
        // System.out.println("Y: "+cntY);
        
        boolean answer = true;
        
        if(cntP!=cntY){
            answer = false;
        }
        


        return answer;
    }
}