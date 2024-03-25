import java.util.*;

class Solution {
    public int solution(String dirs) {
        
        char [] comm = dirs.toCharArray();

        int startR = 5;
        int startC = 5;
        int newR = startR;
        int newC = startC;
        int tmpR, tmpC;
        
        HashSet<String> stepped = new HashSet<>();
        
        
        for(int i = 0; i < comm.length; i++){
            char thisComm = comm[i];
                       
            switch(thisComm){
                case 'U':
                    tmpR = newR-1;
                    tmpC = newC;
                    
                    if(tmpR<0) continue;        
                    
                    doTheSet(newR, newC, tmpR, tmpC, stepped);      
                    newR = tmpR;
                    newC = tmpC;
                    
                    break;
                case 'D':
                    tmpR = newR+1;
                    tmpC = newC;
                    
                    if(tmpR>10) continue;
                    
                    doTheSet(newR, newC, tmpR, tmpC, stepped);      
                    newR = tmpR;
                    newC = tmpC;
                    break;
                case 'L':
                    tmpR = newR;
                    tmpC = newC-1;

                    if(tmpC<0) continue;
                    
                    doTheSet(newR, newC, tmpR, tmpC, stepped);      
                    newR = tmpR;
                    newC = tmpC;
                    break;
                case 'R':
                    tmpR = newR;
                    tmpC = newC+1;
                    
                    if(tmpC>10) continue;

                    doTheSet(newR, newC, tmpR, tmpC, stepped);      
                    newR = tmpR;
                    newC = tmpC;
                    break;
            }
        }
        return stepped.size()/2;
    }
    
    
    public static void doTheSet(int originR, int originC, int tempR, int tempC, HashSet<String> set){

        StringBuilder sb = new StringBuilder();
        String one = sb.append(originR).append(originC).append(tempR).append(tempC).toString();
        sb.setLength(0);
        String two = sb.append(tempR).append(tempC).append(originR).append(originC).toString(); 

        set.add(one);
        set.add(two);

    }
    
}