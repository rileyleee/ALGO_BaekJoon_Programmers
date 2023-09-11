import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        
        int L = A.length;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int tempAns1 = 0;
        
        int tempAns2 = 0;
        
        for(int i = 0; i<L; i++){
            int temp1 = A[i]*B[L-1-i];
            tempAns1+=temp1;
            
            int temp2 = A[L-1-i]*B[i];
            tempAns2+=temp2;
        }
        
        int answer = Math.min(tempAns1, tempAns2);

        return answer;
    }
}