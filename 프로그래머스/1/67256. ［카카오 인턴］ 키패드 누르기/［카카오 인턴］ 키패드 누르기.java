import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        
        int[][] phone = {{0,3,1},{1,0,0},{2,0,1},{3,0,2},{4,1,0},{5,1,1},{6,1,2},{7,2,0},{8,2,1},{9,2,2},{10,3,0},{11,3,2}};
        
        int left = 10;
        int right = 11;
        int lDist = -1;
        int rDist = -1;
        
        for(int i =0; i<numbers.length; i++){
            if(numbers[i]==1||numbers[i]==4||numbers[i]==7){
                left = numbers[i];
                sb.append("L");
            }else if(numbers[i]==3||numbers[i]==6||numbers[i]==9){
                right = numbers[i];
                sb.append("R");
            }else{ 

                lDist = (Math.abs(phone[left][1] - phone[numbers[i]][1])+(Math.abs(phone[left][2] - phone[numbers[i]][2])));
                rDist = (Math.abs(phone[right][1] - phone[numbers[i]][1])+(Math.abs(phone[right][2] - phone[numbers[i]][2])));

                System.out.println("현재 왼손: "+left);
                System.out.println("현재 오른손: "+right);  
                
                System.out.println("lDist: "+lDist);
                System.out.println("rDist: "+rDist);     
                System.out.println("=========================================");
                
                
                if(lDist==rDist){
                    if(hand.equals("right")){
                        right = numbers[i];                    
                        sb.append("R");
                    }else{
                        left = numbers[i];
                        sb.append("L");
                    }
                }else if(lDist<rDist){
                    left = numbers[i];
                    sb.append("L");
                }else{
                    right = numbers[i];
                    sb.append("R");
                }
            }
        }
        
        answer = sb.toString();
        
        return answer;
    }
}