class Solution {
    private static int find, answer;
    public int solution(int[] numbers, int target) {
        answer = 0;        
        int total = 0;
        
        for(int i =0; i<numbers.length; i++){
            total+=numbers[i];
        }
        
        find = (total-target)/2;
        

        dfs(0, numbers, 0);

        
        return answer;
    }
    
    private static void dfs (int thisNum, int [] numbers, int sum){    
        
         if(sum == find){            
            answer++;
            //System.out.println("더했어요: " + answer);
            return;
        } else if(sum > find) return;
        
      
        if(thisNum == numbers.length) return;
        
        //System.out.println("이번 인덱스: " + thisNum);
        
        
        
       

        int tmp = sum + numbers[thisNum];
        
        dfs(thisNum+1, numbers, tmp); //선택한 경우
        dfs(thisNum+1, numbers, tmp-numbers[thisNum]); //선택 안 한 경우
        
        
    }
}