import java.util.*;

class Solution
{
    public int solution(int []A, int []B) { //그리디 알고리즘
        
        int L = A.length;
        
        int answer = 0;
        
        // 먼저 각 배열을 정렬하고
        Arrays.sort(A); 
        Arrays.sort(B);  
        
        // 오름차순 및 내림차순으로 값을 계산하기
        for(int i = 0; i<L; i++){
            int temp = A[i]*B[L-1-i];
            answer+=temp;
        }

        return answer;
    }
}