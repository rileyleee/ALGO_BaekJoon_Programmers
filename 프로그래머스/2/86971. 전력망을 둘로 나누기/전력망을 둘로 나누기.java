import java.util.*;

class Solution {
    public static boolean[] visited;
    public static ArrayList<Integer>[] adjList;
    public static int answer, N;
    public int solution(int n, int[][] wires) {
        
        
        N =n;
        answer = n-1;
        
        adjList = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[]wire : wires){
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }
        
        visited = new boolean[n+1];
        
        dfs(1);    

        return answer;
    }
    
    public static int dfs(int now){
        visited[now] = true;
        
        int towerSum = 0;
        
        for(int connected : adjList[now]){
            if(!visited[connected]){
                int cnt = dfs(connected);
                answer = Math.min(answer, Math.abs(N-cnt*2));
                
                towerSum +=cnt;
            } 
        }
        return towerSum+1;
    }
}