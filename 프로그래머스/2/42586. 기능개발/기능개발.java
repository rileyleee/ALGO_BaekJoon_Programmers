import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[]answer = {};
        List<Integer>temp = new ArrayList<>();
        Queue<Integer> qu = new LinkedList<>();
        
        for(int i =0; i<progresses.length; i++){
            qu.add((int)Math.ceil((double)(100-progresses[i])/speeds[i]));       
        }
        
        while(!qu.isEmpty()){
            int days = qu.poll();
            int funcs = 1;
            
            while(!qu.isEmpty()&& days >= qu.peek()){
                funcs++;
                qu.poll();
            }
            temp.add(funcs);
        }
        answer = temp.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}