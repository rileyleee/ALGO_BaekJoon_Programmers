import java.util.*;

class Solution {
    public static int dgNum, answer, K;
    public static int[] exploreOrd;
    public static int[][] dungeon;
    public static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        K = k;
        
        dgNum = dungeons.length;
        
        exploreOrd = new int[dgNum];
        visited = new boolean[dgNum];
        dungeon = new int[dgNum][2];
        
        for(int i = 0; i<dgNum; i++){
            dungeon[i][0] = dungeons[i][0];
            dungeon[i][1] = dungeons[i][1];
        }
        
        // 던전 번호 0부터 최대 길이까지 던전 순서 정하기(모든 경우의 수)
        makeOrder(0);       
                        
        return answer;
    }
    
    private static void makeOrder(int curr){
        
        if(curr == dgNum){
            
            //System.out.println(Arrays.toString(exploreOrd));
            
            // 정해진 순서대로 k값을 변경해가며 탐험
            explore(K, exploreOrd);
            return;
        }
        
        for(int i = 0; i<dgNum; i++){
            
            if(visited[i]) continue;
            
            exploreOrd[curr] = i;
            visited[i] = true;
            makeOrder(curr+1);
            exploreOrd[curr] = 0;
            visited[i] = false;
            
        }
        
    }
    
    private static void explore(int currK, int[] order){
        int possi = 0;
        
        for(int i = 0; i<dgNum; i++){
            //System.out.println("currK: " + currK);
            if(currK >= dungeon[order[i]][0]){
                currK -= dungeon[order[i]][1];
                possi++;                
            }            
        } 
        
        //System.out.println("possi: " + possi);
        //System.out.println("=========================================");
        
        // 탐험 가능한 던전 수 최대값으로 갱신
        answer = Math.max(answer, possi);
    }
}