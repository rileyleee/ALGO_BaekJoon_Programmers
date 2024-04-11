import java.util.*;

class Solution {
    public static HashMap<String, PriorityQueue<String>> tks;
    public static ArrayList<String> answer;

    public String[] solution(String[][] tickets) {
        tks = new HashMap<>();
        answer = new ArrayList<>();

        // 인접리스트에 티켓 추가
        for (String[] ticket : tickets) {
            tks.putIfAbsent(ticket[0], new PriorityQueue<>());
            tks.get(ticket[0]).add(ticket[1]);
        }

        // DFS로 경로 탐색
        dfs("ICN");

        // 경로 정렬
        Collections.reverse(answer);
        
        return answer.toArray(new String[0]);
    }

    public static void dfs(String depart) {
        // 출발지가 티켓에 없거나 티켓을 모두 사용했을 경우
        while (tks.containsKey(depart) && !tks.get(depart).isEmpty()) {
            String arrival = tks.get(depart).poll();
            dfs(arrival);
        }
        // 경로에 추가
        answer.add(depart);
    }
}