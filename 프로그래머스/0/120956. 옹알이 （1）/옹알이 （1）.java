class Solution {
    public int solution(String[] babbling) {
         
        int answer = 0;
        
        String[] possible = {"aya", "ye", "woo", "ma"};
        
        for(String b: babbling){
            for(String p: possible){
                b = b.replace(p, "-");
            }
            
            b= b.replace("-","");
            
            if(b.equals("")) {
                answer++;
            }
        }
        
        
      
        return answer;
    }
}