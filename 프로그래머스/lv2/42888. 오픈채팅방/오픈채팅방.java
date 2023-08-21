import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        // 아이디와 닉네임을 연결할 맵
        Map<String, String> map = new HashMap<>();

        // change를 제외한 답을 넣을 리스트 생성
        List<String> tempAnswer = new ArrayList<>();
        
        for(int i = 0; i < record.length; i++){
            
            String[] eachRecord = record[i].split(" ");
            
            if(eachRecord[0].equals("Enter")||eachRecord[0].equals("Leave")){
                tempAnswer.add(record[i]);
            }
            
            if(eachRecord.length==3){
                map.put(eachRecord[1], eachRecord[2]);
            }               
        }
                
        String[] answer = new String[tempAnswer.size()];
        
        
        for(int i =0; i<answer.length; i++){
            String [] tempInfo = tempAnswer.get(i).split(" ");
            answer[i] = map.get(tempInfo[1]);
            
            if(tempInfo[0].equals("Enter")){
                answer[i]+="님이 들어왔습니다."; 
            }else if(tempInfo[0].equals("Leave")){
                answer[i]+="님이 나갔습니다."; 
            }
        }
        return answer;
    }
}