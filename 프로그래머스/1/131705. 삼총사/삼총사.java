import java.util.*;


class Solution {
    private static boolean[] visited;
    private static int[] copy;
    
    private static int answer;
    public int solution(int[] number) {
        
        answer = 0;
        
        Arrays.sort(number);
        System.out.println(Arrays.toString(number));
    
        visited = new boolean[number.length];
        copy = number.clone();
        
        
        
        findTrio(0, 0,-1);
                
        
        return answer;
    }
    private static void findTrio(int curr, int sum, int before){
        
        if(curr==3){
            if(sum==0) answer++;
            return;
        }
        
        
        for(int i = 0; i<copy.length; i++){
            if(visited[i] || before>=i) continue;
            
            visited[i] = true;            
            sum+=copy[i];
            findTrio(curr+1, sum, i);
            visited[i] = false;
            sum-=copy[i];
            
            
        }
        
    }
}