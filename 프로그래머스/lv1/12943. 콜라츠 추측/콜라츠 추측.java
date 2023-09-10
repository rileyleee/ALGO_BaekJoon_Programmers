class Solution {
    public int solution(int num) {
        int answer = 0;
        
        if(num!=1){
            while(num>1){
               if(num%2==0){ // 짝수라면
                   num = num/2;
                   answer++;

               }else{ // 홀수라면
                   num = num*3+1;
                   answer++;
               }
                if(answer>500&&num>1||num<0){
                    answer = -1;
                    break;
                }
            }
        }
        System.out.println(num);
        return answer;
    }
}