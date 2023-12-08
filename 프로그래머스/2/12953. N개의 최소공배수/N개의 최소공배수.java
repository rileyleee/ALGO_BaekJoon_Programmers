import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        Arrays.sort(arr);
        
        for(int i = 1; i<arr.length; i++){
            int gcdNum = gcd(answer, arr[i]);
            answer = answer * arr[i]/gcdNum;
        }
        
        
        return answer;
    }
    
    // 최대 공약수 구하기    
    public static int gcd(int a, int b){
        
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        
        return a;
        
    }
}