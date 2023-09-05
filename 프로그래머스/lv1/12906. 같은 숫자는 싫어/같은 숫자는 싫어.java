import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stk = new Stack<>();

        for(int i =0; i<arr.length; i++){
            
            if(i == 0){ // 첫번째 값일 때는
                stk.push(arr[i]); //무조건 넣기
            } else if(stk.peek()!=arr[i]){
                stk.push(arr[i]); //값 넣기
            }  
        }
        
        System.out.println("스택 길이: "+stk.size());
        
        // 스택의 길이로 반복문 횟수를 정하면 안되는 이유
        // pop을 하면서 스택의 길이가 동적으로 변경되기 때문에
        // 최대 반복 횟수가 반복문을 돌면서 줄어듦 잊지 말자.
        
        
        int[] answer = new int[stk.size()];
        int index = stk.size() - 1;
        
        while(!stk.isEmpty()){         
            answer[index] = stk.pop(); 
            index--;
        }
        
        return answer;
    }
}