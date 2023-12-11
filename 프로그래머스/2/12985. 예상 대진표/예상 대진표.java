class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(a!=b){
            answer++;
            if(a%2!=0){
                a++;
            }
            if(b%2!=0){
                b++;
            }
            a = a/2;
            b = b/2;
        }
        
      
            
        

        return answer;
    }
}