import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        
        
        int len = strings.length;
        
        String[] answer = new String [len];
;        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0; i<len; i++){
            list.add(strings[i].charAt(n)+strings[i]);
        }
        
        Collections.sort(list);
        
        
        for(int i = 0; i < list.size(); i++){
           answer[i] = list.get(i).substring(1,list.get(i).length());
        }
        
        
        
        return answer;
    }
}