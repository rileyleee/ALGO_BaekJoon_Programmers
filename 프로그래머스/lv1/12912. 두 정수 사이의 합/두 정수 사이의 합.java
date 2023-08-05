class Solution {
    public long solution(int a, int b) {
        
        long answer = 0;
        
        if(a>b){  // 항상 b가 큰 수
            int temp = b;
            b = a;
            a = temp;
        }
        
                
        for(int i = a; i <= b; i++){
            answer+=i;
        }
        
        if(a==b){
            answer = b;
        }

        
        
        return answer;
    }
}