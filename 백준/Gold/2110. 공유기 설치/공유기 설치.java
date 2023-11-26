import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int house = sc.nextInt();
        int c = sc.nextInt();

        int[] hArr = new int[house];

        for (int i = 0; i < hArr.length; i++) {
            hArr[i] = sc.nextInt();
        }

        Arrays.sort(hArr); // 좌표 순으로 정렬

        int close = 1; // 공유기 간 가능한 최소 거리(집 좌표가 겹치지 않기 때문에)
        int far = hArr[house - 1] - hArr[0]; // 공유기 간 가능한 최대 거리

        int answer = 0;

        while (close <= far) { // 이분 탐색 수행
            int mid = (close + far) / 2; // 중간 거리

            int start = 0; // 공유기를 첫번째 집에 설치
            int cnt = 1; // 공유기 설치 대수

            for (int i = 1; i < house; i++) {
                if (hArr[i] - hArr[start] >= mid) { //직전 설치 공유기와의 거리가 중간거리보다 같거나 크면
                    cnt++; // 설치한 것으로 처리하고
                    start = i; // 직전 공유기 위치 반영
                }
            }
            // 다 설치 완료했는데 설치 대수와 지급 대수가 차이가 난다면
            // mid를 조정하기 위해 far 또는 close를 조정하는데
            // mid를 하나씩 조정하는 게 아니라 반 씩 뚝뚝 조정하는 것이
            // 해를 찾는데 시간 효율을 높이는 핵심인 것..
            if (cnt < c) {  // 적게 설치 했다면
                far = mid - 1; // 중간 거리보다 짧게 최대거리 조정
            } else { // 많이 설치 했거나 같게 설치했다면
                answer = mid;
                close = mid + 1; // 최소 거리를 중간거리보다 멀게 최소 거리 조정
            }
        }
        System.out.println(answer);
    }
}