import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int len = topping.length;
        
        int [] order = new int[len];
        int [] reverseOrder = new int[len];
        
        // 앞과 뒤에서부터 센 토핑의 가짓 수를 Set을 이용해서 구하고
        HashSet<Integer> former = new HashSet<>(); 
        HashSet<Integer> latter = new HashSet<>(); 
        
        for(int t = 0; t < len; t++) {
            former.add(topping[t]);
            order[t] = former.size();      
            
            latter.add(topping[(topping.length-1)-t]);
            reverseOrder[(topping.length-1)-t] = latter.size();
        }
        
        //System.out.println(Arrays.toString(order));
        //System.out.println(Arrays.toString(reverseOrder));
        
        for(int i = 0; i<len-1; i++){
            if(order[i]==reverseOrder[i+1]) answer++;
        }
           
                
        return answer;
    }
    

}