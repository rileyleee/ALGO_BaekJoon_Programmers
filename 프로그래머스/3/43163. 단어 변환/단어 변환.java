import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        boolean visited [] = new boolean[words.length];
        HashMap<String, Integer> map = new HashMap<>();
        
        map.put(begin, 0);
        
        // 최소 몇 단계 -> BFS -> 큐
        int answer = 0;
        
        // 만약 타겟이 단어 집합에 없으면 0 리턴
        boolean non_exist = true;
        for(String s : words){
            map.put(s, 0);
            if(s.equals(target)) non_exist = false;
        }
        
        if(non_exist) return 0;
        
        Queue<String> qu = new LinkedList<>();
        
        qu.offer(begin);
        
        
        while(!qu.isEmpty()){
            
            String curr = qu.poll();   
            System.out.println("이번 단어: "+curr);
            
            for(int i = 0; i<words.length; i++){
                int same = 0;
                
                if(visited[i]) continue;
                for(int j = 0; j<words[i].length(); j++){
                    if(curr.charAt(j) == words[i].charAt(j)) same++;
                }
                
                if(same == words[i].length() - 1) {
                    qu.offer(words[i]);
                    visited[i] = true;
                    map.put(words[i], map.get(curr)+1);
                }
                
            }
        }
        
        answer = map.get(target);
    
        
        
        return answer;
    }
}