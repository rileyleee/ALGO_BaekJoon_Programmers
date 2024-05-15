import java.util.*;

class Solution {
    public int solution(int[][] routes) {
                
        // 나가는 지점이 가장 빠른 경로 순으로 정렬하고 일단 설치
        Arrays.sort(routes, (o1,o2) -> o1[1]-o2[1]);
        
        int answer = 1;
        
        // for(int[] i : routes){
        //     System.out.println(i[0]+ " "+i[1]);
        // }
        
        // 가장 먼저 진출하는 차량의 마지막 지점을 저장        
        int end = routes[0][1];
        
        // 그 이후 경로 순회하면서
        
        for(int i =1; i<routes.length; i++){
            // 이전 마지막 위치와 겹치면 지나가고
            if(routes[i][0]<=end&&routes[i][1]>=end) continue;
            else{ // 아니라면 마지막 지점 갱신하고
                end = routes[i][1];
                answer++; //한 대 추가 설치
            }
        }
                
        
        return answer;
    }
}