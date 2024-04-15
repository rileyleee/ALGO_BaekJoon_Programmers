class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while (n > 0) {
            int remainder = (n - 1) % 3; // 0부터 시작하는 3진법을 0부터 시작하는 3진법으로 변환
            answer.insert(0, String.valueOf(remainder == 0 ? 1 : remainder == 1 ? 2 : 4));
            n = (n - 1) / 3;
        }

        return answer.toString();
    }
}
