import java.util.*;

class Solution {
    public static int [] answer;
    public static HashMap<String, String> chain;
    public static HashMap<String, Integer> order;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        answer = new int[enroll.length];
        chain = new HashMap<>();
        order = new HashMap<>();
        
        for(int i =0; i<enroll.length; i++){
            chain.put(enroll[i], referral[i]);
            order.put(enroll[i], i);
        }
        
        for(int i =0; i<seller.length; i++){
            addProfits(seller[i], amount[i]*100);
        }
           
        return answer;
    }
    
    public static void addProfits(String sellerName, int amt){
        
        if(!chain.containsKey(sellerName)) return;
        
        double tenPercent = Math.floor(amt*0.1);
        int remaining = amt - (int)tenPercent;
        
        if(tenPercent<1) answer[order.get(sellerName)] +=amt;
        else{            
            addProfits(chain.get(sellerName), (int)tenPercent);
            answer[order.get(sellerName)] +=remaining;     
            
        }       
        
    }
}