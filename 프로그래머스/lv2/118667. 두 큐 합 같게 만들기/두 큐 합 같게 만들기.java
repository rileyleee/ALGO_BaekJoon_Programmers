import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {        
        int answer = 0; //초기화
        
        Queue<Integer> qu1 = new LinkedList<>();
        Queue<Integer> qu2 = new LinkedList<>();
        
        long eachSum1 = 0L;    
        long eachSum2 = 0L;   
        
        for(int a =0; a<queue1.length; a++){
            eachSum1+=queue1[a];
            qu1.add(queue1[a]);
        }
        
         for(int a =0; a<queue2.length; a++){
            eachSum2+=queue2[a];
            qu2.add(queue2[a]);
        }
        if((eachSum1+eachSum2)%2==1){ // 합이 홀수면
            return -1; // 안되는 게임이다 이거야
            
        } else{ // 짝수면 고
            long sum = (eachSum1+eachSum2)/2; 
            int deadline = 600000;
            
             while(deadline -- > 0){
                 
            //합이 큰 쪽에서 빼고 작은 쪽에 넣어주기
            if(eachSum1>eachSum2){
                
                if(qu1.peek()>sum){ // 만들어야 하는 값보다 큰 원소가 존재하면 애초에 안 됨
                    return -1;
                }
                
                int temp = qu1.poll();
                qu2.add(temp);
                eachSum1-=temp;
                eachSum2+=temp;
                answer++;
                
            }else if(eachSum2>eachSum1){
                
                if(qu2.peek()>sum){ // 만들어야 하는 값보다 큰 원소가 존재하면 애초에 안 됨
                    return -1;
                }
                
                int temp = qu2.poll();
                qu1.add(temp);
                eachSum2-=temp;
                eachSum1+=temp; 
                answer++;
                
            }else if (eachSum1==eachSum2){ // 두 큐의 합이 같은 경우 
                break;
            }
        }
        if (deadline<=0){
            return -1;
        }else{
            return answer;
        }
    }
  }        
}