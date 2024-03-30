import java.util.*;

class Solution {
    public static int[] parents;
    public static int find(int i){
        if(parents[i] == i) return parents[i];
        
        parents[i] = find(parents[i]);
        return parents[i];
    }
    
    public static void union(int i, int j){
        int rootI = find(i);
        int rootJ = find(j);
        parents[rootJ] = rootI;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int connected = 1;
        
        parents = new int[n];
        
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2)->          
            Integer.compare(o1[2], o2[2]));
        
        for(int[] edge : costs){            
            
            if(connected == n-1) break;
            
            if(find(edge[0])!=find(edge[1])) {
                union(edge[0], edge[1]);
                answer+=edge[2];
            }
                      
        } 
        
        return answer;
    }
}