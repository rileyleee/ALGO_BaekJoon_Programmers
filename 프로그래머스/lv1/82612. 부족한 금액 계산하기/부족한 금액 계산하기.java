class Solution {
    public long solution(int price, int money, int count) {

        long totalPrice = price;
        int i = 1;
        long newPrice = 0;
        
        while(i<=count){            
            i++; 
            totalPrice += newPrice;            
            newPrice = price*(i);      
        }
        
        long answer = totalPrice-money;
        
        if(answer<0){
            answer = 0;
        }

        return answer;
    }
}