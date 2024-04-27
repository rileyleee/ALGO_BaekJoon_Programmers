import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        /** 
        캐시 미스는 캐시에 없을 때 캐시 히트는 캐시에 있을 때
        */
        
        /**
        먼저 들어온 순서를 파악해야 하고        
        있던 도시를 가게 된다면 그 친구를 꺼내서 맨 뒤로 넣어야 함(최근에 사용됨을 보장)
        TreeMap이 맞을 것 같은데 키는 도시명 값은 인덱스         
        캐시 크기는 사이즈로 관리        
        있다면 +1 있던 도시 방문하면 map에서 삭제하고 다시 현재 인덱스로 넣어줌
        없다면 가장 앞에 있는 값 삭제        
        treeMap에 넣을 때 구조는 인덱스와 도시이름으로(lowercase로) 넣고 +5 
        */
        
        TreeMap<Integer, String> cache = new TreeMap<>(); 
        
        if(cacheSize==0){
            answer = cities.length*5;            
        }else{
        
            // 첫 도시는 무조건 비어있으니까 그냥 넣기
            cache.put(0, cities[0].toLowerCase());
            answer+=5;

            // 도시이름 배열 순환하면서
            for(int i = 1; i<cities.length; i++){

                String thisCity = cities[i].toLowerCase();

                // 존재 여부를 매번 체크
                if(cache.containsValue(thisCity)){ // 이미 존재한다면
                    answer++; // 실행시간 더해주고

                    for(int k : cache.keySet()){
                        if(cache.get(k).equals(thisCity)) {
                            cache.remove(k); // 삭제하고
                            break;
                        }                    
                    }
                    // 다시 넣어줌 -> 맨 뒤로 들어가겠지
                    cache.put(i, thisCity);
                }else{ // 존재하지 않는데
                    answer += 5;

                    // 이미 캐시가 다 찼다면 방문한 지 가장 오래된 도시 삭제  
                    if(cache.size()==cacheSize) {
                        cache.remove(cache.firstKey()); 
                        cache.put(i, thisCity);
                    }
                    // 차지 않았다면
                    else cache.put(i, thisCity); // 현재 도시 넣어줌                                 
                }
            }
        }
        
        return answer;
    }
}