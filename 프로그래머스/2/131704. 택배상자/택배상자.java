import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Deque<Integer> stk = new ArrayDeque<>();
                    
        // index는 1부터 시작하는데        
        int index = 1;
        
        // order 반복문을 돌면서 
        for(int i = 0; i<order.length; i++){
            int curr = order[i];
            //System.out.println("==================");
            //System.out.println("지금 숫자는: "+curr);
            // index 또는 보조 컨테이너에서 꺼낼 수 있는 수와 하나라도 일치하면 answer++;
            // 스택에 있는 제일 위의 수와 같다면
            if(!stk.isEmpty() && stk.peek()==curr){
                //System.out.println("보조컨테이너에서 찾았어: "+stk.peek());
                stk.pop();
                answer++;
            }// 지금 싣게 될 박스 번호와 같다면
            else if(index==curr){
                //System.out.println("index랑 같아오 :"+index);
                answer++;
                index++;
            }// 두 곳 모두에서 찾을 수 없는데 컨테이너 벨트에 있는 박스 숫자가 더 작다면
            else if(index<curr){
                while(index<curr){
                    //System.out.println("보조컨테이너에 넣었어요: "+ index);
                    stk.push(index++);
                }
                if(index==curr) {
                    answer++;
                    index++;
                } 
            }else break; // 어느 곳에서도 찾을 수 없고 대상 박스 숫자보다 컨베이어벨트 숫자가 더 크다면 중단 
        }
              
        
        
        return answer;
    }
}