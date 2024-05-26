import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int max, house, n;
    private static int[] place, bees;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 장소 수 입력 받기
        n = Integer.parseInt(br.readLine());

        // 장소 배열 생성
        place = new int[n + 1];

        // 방문 배열 생성
        visited = new boolean[n + 1];

        // 벌 위치 배열 생성
        bees = new int[2];

        // 장소별 꿀 숫자 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) place[i] = Integer.parseInt(st.nextToken());
        br.close();

        //System.out.println("장소 배열: " + Arrays.toString(place));

        // 최대값 초기화
        max = Integer.MIN_VALUE;

        // 장소를 순회하면서 벌통 지정하기
        for (int i = 1; i <= n; i++) {
            house = i;
            // 재귀로 꿀벌 위치 2개 뽑기
            beesLocation(0);
        }
        System.out.println(max);
    }

    private static void beesLocation(int located) {
        if (located == 2) {
            //System.out.println("============================================================");
            //System.out.println("벌통의 위치: " + house + " 벌들의 위치: " + Arrays.toString(bees));
            // 다 뽑은 후에 벌통까지 채집 가능한 꿀의 양을 구하기
            honey();
            return;
        }

        for (int i = 1; i <= n; i++) {

            // 이미 방문했거나 벌통이거나 역순인 경우 제외
            if (visited[i] || i == house || (located != 0 && bees[0] >= i)) continue;

            bees[located] = i;
            visited[located] = true;
            beesLocation(located + 1);
            bees[located] = 0;
            visited[located] = false;
        }

    }

    private static void honey() {

        int[] copyPlace = place.clone();
        //System.out.println("장소 배열: " + Arrays.toString(copyPlace));

        // 꿀벌 위치는 채집 불가함
        copyPlace[bees[0]] = 0;
        copyPlace[bees[1]] = 0;

        int temp = 0;

        for (int i = 0; i < 2; i++) {

            // 벌통 인덱스 비교를 통해 방향 정하기
            if (house > bees[i]) {
                for (int j = bees[i]; j <= house; j++) temp += copyPlace[j];
            } else {
                for (int j = bees[i]; j >= house; j--) temp += copyPlace[j];
            }
        }

        //System.out.println("꿀의 양: " + temp);

        // 최대값 갱신하기
        max = Math.max(temp, max);
    }
}