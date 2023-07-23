import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 오늘 날짜
        int tYear = Integer.parseInt(today.substring(0, 4));
        int tMonth = Integer.parseInt(today.substring(5, 7));
        int tDate = Integer.parseInt(today.substring(8, 10));            
        
        int tCount = terms.length;// 약관의 수     
        int pCount = privacies.length;// 개인정보의 수        
        int [] temp = new int[pCount];// 응답 임시 배열 생성       
        int count = 0;// 파기해야 할 개인정보 수
        
        // 각 개인정보별 처리
        for(int a =0; a<pCount; a++){
            String data = privacies[a];
            // 년월일 데이터 추출
            int year = Integer.parseInt(data.substring(0, 4));
            int month = Integer.parseInt(data.substring(5, 7));
            int date = Integer.parseInt(data.substring(8, 10));
            // 마지막 한 글자는 약관 종류
            String type = data.substring(data.length()-1, data.length());
            
            for(int b =0; b<tCount; b++){
                // 약관 종류가 일치한다면
                if(terms[b].substring(0,1).equals(type)){
                    // 유효기간 추출
                    int expireM = Integer.parseInt(terms[b].substring(2)); 
                    // 임시 월
                    int tempM = month+expireM;                    
                    
                    //유효기간이 12의 배수인 경우                    
                    if(expireM%12==0){
                        year += expireM/12; //몫만큼 더해주고                            
                        if(date == 1){ //1일이면
                            date = 28; //마지막 일자로 변경후
                            month--; //이전 월로 변경
                        }else{ //1일이 아니면
                            date--; // 하루만 줄여줘
                        }                        
                    }else{//유효기간이 12의 배수가 아닌 경우                        
                        
                        
                        // 유효기간으로 해가 넘어가는 경우
                        if(tempM>=13){
                            year+=tempM/12;   
                            month = tempM%12;
                        }else{ // 해가 넘어가지 않고 유효기간이 12의 배수가 아닌 경우
                            month = tempM;     
                        }
                        
                        // 공통
                        if(date ==1){
                            date =28;
                            month--;
                        }else{
                            date--;
                        }
                    }
                    // 월 반영
                    if(month==0){ // 기준일이 1월인 경우 0월이 되었으니
                        month = 12; //12월로 변경
                        year--;
                    }    
                      
                    
                    System.out.println(year+" "+month+" "+date);
                    
                    //오늘과 유효기간 연월일 순서대로 일일이 비교
                    if(tYear<year){
                        continue;
                    }else if(tYear==year){
                        if(tMonth<month){
                            continue;
                        }else if(tMonth==month){
                            if(tDate<=date){
                                continue;
                            }
                        }                        
                    }
                    // 그외의 경우는 모두 값을 더해줌
                    count++;
                    temp[a] = a+1;
                }                                   
            }                        
        }
        int[] answer = new int[count];
        int idx = -1;
        for(int a =0; a<temp.length; a++){           
            if(temp[a]!=0){
                idx++;
                answer[idx] = temp[a];
            }
        }       
        return answer;
    }
}