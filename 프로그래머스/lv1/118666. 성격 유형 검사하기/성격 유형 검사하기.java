import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        // 각 지표별 배열 
        int [] type = new int[21];
        
        int sLength = survey.length;
        
        for(int i = 0; i < sLength; i++){
            int response = choices[i];
            int fl = survey[i].substring(0,1).charAt(0)-64;
            int sl = survey[i].substring(1).charAt(0)-64;
           
            if(response<4){
                type[fl]+=4-response;             
            }else if(response>4){
                type[sl]+=response-4;
            }
            

              // System.out.println(fl);
              // System.out.println(sl);


             // 18 20, 3 6, 10 13, 1 14

            
            }
        
        StringBuilder sb = new StringBuilder();
        // int R,
        // for(int i = 0; i<type.length; i++) {
        //     int R = type[18]; int T = type[20]; int C = type[3]; int F = type[6];
        //     int J = type[10]; int M = type[13]; int A = type[1]; int N = type[14];            
        // }
        
        if(type[18]>=type[20]) sb.append("R");
        else sb.append("T");
        
        if(type[3]>=type[6]) sb.append("C");
        else sb.append("F");
        
        if(type[10]>=type[13]) sb.append("J");
        else sb.append("M");
        
        if(type[1]>=type[14]) sb.append("A");
        else sb.append("N");
            
            
        
        
        
        
        
        
        String answer = sb.toString();
        
        return answer;
    }
}