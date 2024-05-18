import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        List<Integer> answer = new ArrayList<>();
        
        HashSet<String> set = new HashSet<>();
        
        
        String[] split = s.split("\\},\\{");
        
        //System.out.println(Arrays.toString(split));
        
        split[0] = split[0].replaceAll("[{}]", "");
        split[split.length-1] = split[split.length-1].replaceAll("[{}]", "");
        
        //System.out.println(Arrays.toString(split));
        
        String[][] sorted = new String[split.length][];
        
        for(int i = 0; i<split.length; i++){
            String[] curr = split[i].split(",");
            sorted[curr.length-1] = curr;
        }
        
        for(int i = 0; i<sorted.length; i++){
            for(int j = 0; j<sorted[i].length; j++){
                
                if(set.contains(sorted[i][j])) continue;
                
                answer.add(Integer.parseInt(sorted[i][j]));
                set.add(sorted[i][j]);
            }                   
        }
                
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}