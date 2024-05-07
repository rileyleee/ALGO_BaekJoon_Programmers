import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        //System.out.println(Arrays.toString(phone_book));
        
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i<phone_book.length; i++){
            if(!answer) break;
            
            StringBuilder sb = new StringBuilder();
            
            String str = phone_book[i];
            
            for(int c =0; c<str.length(); c++){
                if(!answer) break;
                
                sb.append(str.charAt(c));
                if(set.contains(sb.toString())) answer = false;
                
                   
            }   
            set.add(str);
            
        }
        return answer;
    }
}