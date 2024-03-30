import java.util.*;

class Solution {
    public static Deque<Position> dq;
    public static int dist[][];
    public static int n, m;
    public static class Position{
        int r;
        int c;
        public Position(int x, int y){
            this.r = x;
            this.c = y;       
        }
    }
    public int solution(int[][] maps) {
        int answer = -1;
        
        n = maps.length;
        m = maps[0].length;
        
        dist = new int[n][m];
        
        dist[0][0] = 1;
        dq = new ArrayDeque<Position>();
        
        dq.add(new Position(0, 0));
        
        
        int nr;
        int nc;
        
        while(!dq.isEmpty()){
            int [][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
            
            Position curr = dq.poll();
            
            for(int d = 0; d < 4; d++){
                nr = curr.r + drc[d][0];
                nc = curr.c + drc[d][1];
                
                if(nr < 0||nc < 0|| nr > n-1 || nc > m-1 ||
                   dist[nr][nc]!=0 || maps [nr][nc] == 0) continue; 
                                
                dq.add(new Position(nr, nc));
                dist[nr][nc] = dist[curr.r][curr.c]+1;
            }            
        }     
        
        answer = dist[n-1][m-1]!=0 ? dist[n-1][m-1] : -1;
        return answer;
    }
}
