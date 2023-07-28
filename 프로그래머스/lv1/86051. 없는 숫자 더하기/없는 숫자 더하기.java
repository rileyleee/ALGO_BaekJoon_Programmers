class Solution {
    public int solution(int[] numbers) {
        int [] check = new int[10];
        
        for(int n =0; n<numbers.length; n++){
            check[numbers[n]] = 1;    
        }
        
        int answer = 0;
        for(int c =0; c<10; c++){
            if(check[c]==0){
                answer+=c;
            }
        }

        return answer;
    }
}