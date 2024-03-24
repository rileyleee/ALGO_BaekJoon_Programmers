import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int gamer = stages.length;
        
        int [] cnt = new int [N+1];
        
        for(int i : stages){
            if(i<=N) cnt[i]++;
        }
        
        int [] acc = new int [N+1];
        
        for(int i = 1; i<=N; i++){
            acc[i] = acc[i-1]+cnt[i];
        }
        
        HashMap<Integer, Double> map = new HashMap<>();
        
        for(int i = 1; i<=N; i++){
            map.put(i, (gamer - acc[i - 1] == 0) ? 0 : (double) cnt[i] / (gamer - acc[i - 1]));
        }
     
        
        return map.entrySet().stream().sorted((o1,o2)->Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}