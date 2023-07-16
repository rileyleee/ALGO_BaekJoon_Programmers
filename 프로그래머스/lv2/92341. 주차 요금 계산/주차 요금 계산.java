import java.util.*;

class Solution {
    public List<Integer> solution(int[] fees, String[] records) {
        
        List<Integer> answer = new ArrayList<>();
        
        int mTime = fees[0];
        int mFee = fees[1];
        int pTime = fees[2];
        int pFee = fees[3];
        
        int [] inData = new int[10000];
        
        Arrays.fill(inData, -1);
        int [] durationData = new int[10000];
        
        for(int r =0; r<records.length; r++){
            
            String [] each = records[r].split(" ");
            
            if(each[2].equals("IN")){
            
            int carNum = Integer.parseInt(each[1]);
            String [] sTime = each[0].split(":");
            
            inData[carNum] = (Integer.parseInt(sTime[0])*60)+Integer.parseInt(sTime[1]);
            
            }else{
                int carNum = Integer.parseInt(each[1]);
                
                String [] eTime = each[0].split(":");
            
                int outTime = (Integer.parseInt(eTime[0])*60)+Integer.parseInt(eTime[1]);
                
                durationData[carNum] += outTime-inData[carNum];
                
                inData [carNum] = -1;
            }            
        }
        
        for(int i =0; i<inData.length; i++){
            if(inData[i]!=-1){ 
                durationData[i] += 23*60+59-inData[i];
            }
        }
        
        
        for(int i =0; i<durationData.length; i++){
            if(durationData[i]!=0){
                if(durationData[i]<=mTime){
                    answer.add(mFee);
                }else{
                    int restTime = durationData[i] - mTime;
                    
                    if(restTime%pTime!=0){
                      answer.add(mFee + pFee*(restTime/pTime+1));  
                    }else{                    
                    answer.add(mFee + pFee*(restTime/pTime));
                    }
                }
            }
        }
        
        
        
        
        
        
       
        return answer;
    }
}