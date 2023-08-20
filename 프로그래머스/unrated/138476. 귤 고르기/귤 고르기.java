import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        int [] size = new int[10000001];

        for(int i = 0; i<tangerine.length; i++){
            size[tangerine[i]]++;
        }

        Arrays.sort(size);
        int count = 0;

        for(int i = size.length-1; i>=0; i--){
            if(size[i]!=0){
                k-=size[i];
                count++;
            }
            if(k<=0){
                break;
            }
        }

        int answer = count;
        return answer;
    }
}