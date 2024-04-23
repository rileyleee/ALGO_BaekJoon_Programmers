import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        // 우선순위 큐, 해시맵
        
        // 트리맵
        TreeMap<Integer,Integer> tMap = new TreeMap<>();
        
        // works 배열 순회하면서 키는 남은 작업량 값은 해당 작업의 수로 넣기
        for(int w : works) tMap.put(w, tMap.getOrDefault(w,0)+1);
        
        // for(int k : tMap.keySet()){
        //     System.out.println("k: "+k);
        //     System.out.println("값: "+tMap.get(k));
        // }
        
        // 트리맵의 마지막 엔트리를 가져와서 만약 n보다 값이 더 작다면         
        int lastValue = tMap.lastEntry().getValue();
        int lastKey = tMap.lastEntry().getKey();
        
        while(n>0 && !tMap.isEmpty()){    
            lastValue = tMap.lastEntry().getValue();
            lastKey = tMap.lastEntry().getKey();
             
            if(n >= lastValue){
                // 마지막 키 삭제하기(해당 작업량은 없으니까)
                tMap.remove(lastKey);
                // 일했으니 n값 줄여주기
                n-=lastValue;
                // 마지막 엔트리의 하나 작은 키(현재의 마지막 키)의 값에 해당 값만큼 ++ 해주기                             
                if(lastKey-1!=0){
                    tMap.put(lastKey-1, tMap.getOrDefault(lastKey-1,0)+lastValue);
                    //System.out.println(tMap.lastKey());                    
                }                  
            }// 만약 n이 값보다 작다면 n만큼만 처리하기
            else{                
                tMap.put(lastKey, tMap.getOrDefault(lastKey,0) -n);
                //System.out.println(tMap.lastKey());
                tMap.put(lastKey-1, tMap.getOrDefault(lastKey-1,0) +n);
                n = 0;
            }
            
        }             
        
        // treeMap keySet()으로 꺼내서        
        for(int k : tMap.keySet()){
            //System.out.println("k: "+k);
            int value = tMap.get(k);
            //System.out.println("값: "+value);
            // 값을 제곱해 answer에 더해주기            
            answer+=(Math.pow(k, 2))*value;
        }
        
        
        
        return answer;
    }
}