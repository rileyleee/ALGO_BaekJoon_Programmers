import java.util.Arrays;

class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
                
        int[] answer = new int[2];
        
        int emoticonNum = emoticons.length; // 이모티콘 수
        
        int [] rate = {10,20,30,40}; // 할인율 배열
        
        int [] discountRate = new int[emoticonNum]; // 정해질...할인율 배열
        
        chooseRate(discountRate, rate, 0, users, emoticons, answer);
        
        return answer;
    }

        
        // 할인율 지정해서 재귀로 보내자
        public static void chooseRate(int[] discountRate, int[] rate, int idx, int[][]users, int[] emoticons, int[] answer){
            if(idx == discountRate.length){ // 다 뽑으면
                
                int[] tempAnswer = new int[2];
                
                int[] tempEmoticons = emoticons.clone();
                
                for(int e = 0; e<tempEmoticons.length; e++){
                    tempEmoticons[e] -= (tempEmoticons[e] * discountRate[e]) / 100;
                }
        
                for(int u = 0; u<users.length; u++){ //모든 유저 계산하기
                    int cost = 0;
            
                    for(int e=0;e<tempEmoticons.length; e++){ // 모든 이모티콘 확인해봐
                
                        if(discountRate[e]>=users[u][0]){ // 수용 가능한 할인율이면
                            cost += tempEmoticons[e]; // 이모티콘 산다.
                        }          
                    }
            
                    if(cost >= users[u][1]){ // 구매금액이 예산 이상인 경우
                        tempAnswer[0]++; // 플러스 가입자 늘리기
                    }else{ //그렇지 않다면 매출액만 늘리기
                        tempAnswer[1]+=cost;
                    }   
                }     
                
                if(answer[0]<tempAnswer[0]){ //새로 구한 경우의 가입자 수가 크면 갱신
                    answer[0] = tempAnswer[0];
                    answer[1] = tempAnswer[1];
            
                }else if(answer[0]==tempAnswer[0]){ // 같으면 매출액까지 비교해서 갱신
                    if(tempAnswer[1]>answer[1]){
                        answer[1] = tempAnswer[1];
                    }            
                }
                return;
            }
            
            for(int i =0; i<rate.length; i++){
                discountRate[idx] = rate[i];
                chooseRate(discountRate, rate, idx+1, users, emoticons, answer);                
            }
        }
        

}