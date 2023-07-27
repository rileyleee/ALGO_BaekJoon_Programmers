class Solution {
    public int[] solution(int[] arr) {
        
        if (arr.length==1){
            int [] answer = {-1};     
            return answer;
            
        }else{
           int [] answer = new int [arr.length-1];
            
           int min = Integer.MAX_VALUE;
           for(int a = 0; a < arr.length; a++){
               
               if(arr[a]<min){
                   min = arr[a];
               }               
           }
            
            int i = 0;
            for(int a = 0; a < arr.length; a++){
               if(arr[a]!=min){
                   answer[i] = arr[a];
                   i++;
               }               
           }

            return answer;
        
        }
        
    }
}