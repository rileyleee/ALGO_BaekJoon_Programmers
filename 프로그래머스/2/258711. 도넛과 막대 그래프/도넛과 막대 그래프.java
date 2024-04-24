
import java.util.*;

class Solution {
    public static int point, bar, dn, eight;
    public static PriorityQueue<Integer>[] graph;
    public static PriorityQueue<Integer>[] r_graph;
    public int[] solution(int[][] edges) {

        ArrayList<Integer> answer = new ArrayList<>(); // 정점 번호, 도넛, 막대, 8자 순으로 넣기

        /** 자기자신으로 돌아오면 도넛 (정점과 간선의 갯수 같음)
         자기자신으로 돌아오는데 정점과 간선의 개수 차가 1개이면 8자 (간선 > 정점)
         자기자신과 다른데 정점과 간선의 개수 차가 1개이면 막대 (정점 > 간선)
         도착하는 정점으로서 존재하지 않는 정점이 임의의 정점
         */

        // 도착 정점이 아닌 정점 찾기 위한 boolean 배열
        boolean[] arrive = new boolean[1000001];

        // 인접리스트 또는 인접 우선순위 큐로 구현하면서
        graph = new PriorityQueue[1000001];
        for (int i = 0; i < graph.length; i++) graph[i] = new PriorityQueue<>();
        
        r_graph = new PriorityQueue[1000001];
        for (int i = 0; i < graph.length; i++) r_graph[i] = new PriorityQueue<>();

        int maxPoint = Integer.MIN_VALUE;
        int start, end;

        for (int i = 0; i < edges.length; i++) {
            start = edges[i][0];
            end = edges[i][1];

            graph[start].offer(end);
            r_graph[end].offer(start);

            // 도착 정점인 경우 true로 전환
            arrive[end] = true;

            // 정점의 총 갯수 구하기
            maxPoint = Math.max(Math.max(start, end), maxPoint);
        }

        // System.out.println(maxPoint);

        // 각 그래프 유형별로 변수를 선언하고
        bar = 0;
        dn = 0;
        eight = 0;
        
        
        for (int i = 1; i <= maxPoint; i++){
            if(graph[i].size() >= 2 && r_graph[i].size()==0) point = i;
            if(graph[i].size() >= 2 && r_graph[i].size()>=2) eight++;
            if(graph[i].size() == 0 && r_graph[i].size()>0) bar++;
        }
        
        dn = graph[point].size() - eight - bar;
        answer.add(point);
        answer.add(dn);
        answer.add(bar);
        answer.add(eight);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

   
}

