import java.util.*;

class Solution {
    public static char[][] map;
    public static boolean[][] visited;
    public int[] solution(String[] maps) {
        
        int rLen = maps.length; // 행
        int cLen = maps[0].length(); // 열
        
        map = new char[rLen][cLen];
        
        for(int i = 0; i<rLen; i++){            
            for(int j = 0;j<cLen; j++) 
                map[i][j] = maps[i].charAt(j);            
        }
              
        
        List<Integer> answer = new ArrayList<>();    
        
        
        visited = new boolean[rLen][cLen];
        
        int tmp = 0;
        
        Queue<int[]> qu = new LinkedList<>();
        
        int[][] drc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // 모든 지도 격자를 방문하면서
        for(int i = 0; i < rLen; i++){
            for(int j = 0; j < cLen; j++){
                //System.out.println("===========================");
                //System.out.println(i+", "+j+": "+tmp);
                
                if(!visited[i][j] && map[i][j] != 'X'){
                    qu.offer(new int[]{i,j});
                    visited[i][j] = true;
                    tmp += map[i][j]-48;  
                    //System.out.println(i+", "+j+": "+tmp);
                }
                
                while(!qu.isEmpty()){                    
                    int[] curr = qu.poll();
                    
                    for(int d = 0; d<drc.length; d++){
                        int nr = curr[0]+drc[d][0];
                        int nc = curr[1]+drc[d][1];
                        
                        if(nr<0||nc<0||nr>=rLen||nc>=cLen||visited[nr][nc]||map[nr][nc]=='X') continue;
                        
                        qu.offer(new int[] {nr, nc});
                        visited[nr][nc] = true;
                        tmp+=map[nr][nc]-48;
                        //System.out.println(nr+", "+nc+": "+tmp);
                        
                    }                    
                }
                if(tmp!=0) answer.add(tmp);
                tmp = 0;
            }
        }        
        
        if(answer.size()==0) answer.add(-1);
        Collections.sort(answer);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}