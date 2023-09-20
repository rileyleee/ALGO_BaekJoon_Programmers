import java.util.*;

class Solution{
    public int solution(int n, int[][] computers){
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        Queue<Integer> qu = new LinkedList<>();
        
        for(int i =0;i<computers.length; i++){
            if(visited[i]) continue;
            
            qu.offer(i);
            answer++;
            
            while(!qu.isEmpty()){ // 연결된 애들은 다 방문처리 하기 위함임 그래야 네트워크로 셀 수 없으니
                int curr = qu.poll();
                
                if(visited[curr]) continue;
                
                // 방문하지 않았다면
                visited[curr] = true;
                
                // 그 컴퓨터와 다른 컴퓨터의 연결된 현황 함 보자
                int[] connected = computers[curr];
                
                for(int j =0; j<connected.length; j++){
                    // 이미 방문한 컴퓨터거나 연결되어 있지 않으면 지나가기
                    if(visited[j]||connected[j]==0) continue;
                    
                    qu.offer(j);
                }                
            }                
        }
        return answer;
    }
}