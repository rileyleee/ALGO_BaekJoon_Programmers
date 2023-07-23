class Solution {
    public int solution(int n, int k) {
        
        String newNum = "";
        int answer = 0;
        
        //k진수로 변환        
        newNum = Integer.toString(n, k);
        
        //System.out.println("진수변환수: "+newNum);
        
        StringBuilder sb = new StringBuilder();
        
        char[] each = newNum.toCharArray();

        for(int i = 0; i < each.length; i++){
         
            // 0이 아니면 계속 붙이고
            if(each[i]!='0'){
                sb.append(each[i]);
            }
            
            // 0이거나 마지막 숫자면 판별 시작하고 초기화
            if(each[i] == '0'||i == each.length-1){
                
                if(sb.toString().equals("1") ||sb.length()==0){ //1이거나 길이가 0이면,
                    sb.setLength(0);         // sb 초기화
                    continue;
                    
                }else{
                    long check = Long.parseLong(sb.toString());
                    boolean prime = true;
                    for(int j = 2; j<=Math.sqrt(check); j++){
                        if(check % j == 0){
                            prime = false;
                            break;
                        }
                    }
                    // true로 남아있으면
                    if(prime){
                        answer++;
                    }               
                    sb.setLength(0); //초기화                      
                }
            }
        }       
        
        return answer;
    }
}