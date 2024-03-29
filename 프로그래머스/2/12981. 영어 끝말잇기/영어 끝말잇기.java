import java.util.*; 

class Solution {
    public static int[] answer = {-1, -1};
    public int[] solution(int n, String[] words) {
        
        HashSet<String> set = new HashSet<>();
        char lastLetter= '-';
        
        for(int i = 0; i <words.length; i++){
            
            if(i!=0 && lastLetter!=words[i].charAt(0)){
                findloser(i,n);
                break;
            }
            
            if(!set.contains(words[i])) set.add(words[i]);
            else{
                findloser(i,n);
                break;               
            }
            
            lastLetter = words[i].charAt(words[i].length()-1);                            
        }
        
        if(answer[0] == -1){
            answer[0] = 0;
            answer[1] = 0;
        }
  
    
   return answer;
 }
    public static void findloser(int i, int n){
        if((i+1) % n == 0){
          answer[0] = n; 
          answer[1] = (i+1) / n;
        } else{
          answer[0] = (i+1) % n; 
          answer[1] = (i+1) / n + 1;
        }
    }
}
