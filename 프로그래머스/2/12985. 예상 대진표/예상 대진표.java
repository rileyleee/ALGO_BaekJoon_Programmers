class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        a = a+n-1;
        b = b+n-1;
        
        while(a!=b){
            a /=2;
            b /=2;
            answer++;
        }
            
        

        return answer;
    }
}