import java.util.*;

class Solution {
    public static class delivery{
        int dest;
        int time;
        public delivery(int x, int y){
            this.dest = x;
            this.time = y;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int [] dist = new int[N+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        ArrayList<delivery>[] adjList = new ArrayList[N+1];
        
        for(int i =0; i<=N; i++){
            adjList[i] = new ArrayList<delivery>();
        }
        
        for(int[] data : road){ //무방향이라 양쪽으로 넣어주기
            adjList[data[0]].add(new delivery (data[1], data[2]));
            adjList[data[1]].add(new delivery (data[0], data[2]));
        }
        
        // 가중치가 있는 그래프 => 우선순위 큐로 다익스트라 구현
        PriorityQueue<delivery> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.time, o2.time));
        
        pq.offer(new delivery(1, 0));
        
        while(!pq.isEmpty()){
            delivery curr = pq.poll();
            
            if(curr.time > dist[curr.dest]) continue;
            
            
            for(int i = 0; i< adjList[curr.dest].size(); i++){                
                delivery candidate = adjList[curr.dest].get(i);
                
                if(dist[candidate.dest] > candidate.time + curr.time){
                    dist[candidate.dest] = candidate.time + curr.time;
                    pq.offer(new delivery(candidate.dest, dist[candidate.dest]));
                }                              
            }                       
        }
        
        
        for(int i =1; i<=N; i++){
            if(dist[i]<=K) answer++;
        }
        

        return answer;
    }
}