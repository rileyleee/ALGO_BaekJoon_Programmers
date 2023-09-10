class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String num = String.valueOf(x);
        
        char[] eachNum = num.toCharArray();
        
        int total = 0;
        
        for(int i =0; i<eachNum.length; i++){
            System.out.println("eachNum[i]-0: "+(eachNum[i]-48));
            System.out.println("eachNum[i]: "+eachNum[i]);
            total+=eachNum[i]-48;
        }
        System.out.println("total: "+total);
        
        if(x%total!=0){
            answer = false;
        }
        return answer;
    }
}