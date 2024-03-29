import java.util.*;

class Solution {
    public static int find(int i, int[] parents){
        if(parents[i] == i) return parents[i];
        
        parents[i] = find(parents[i], parents);
        return parents[i];
    }
    
    public static void union(int i, int j, int[] parents){
        int rootI = find(i, parents);
        int rootJ = find(j, parents);
        parents[rootJ] = rootI;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int connected = 1;
        
        int [] island = new int[n];
        
        for(int i = 0; i < n; i++){
            island[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2)->          
            Integer.compare(o1[2], o2[2]));
        
        for(int[] edge : costs){            
            
            if(connected == n-1) break;
            
            if(find(edge[0], island)!=find(edge[1], island)) {
                union(edge[0], edge[1], island);
                answer+=edge[2];
            }
                      
        } 
        
        return answer;
    }
}