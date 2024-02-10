import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[][] lines = new int[n][2];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            lines[i][0] = Integer.parseInt(str.split(" ")[0]);
            lines[i][1] = Integer.parseInt(str.split(" ")[1]);
        }
        br.close();

        Arrays.sort(lines, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) { // 시작점이 같으면
                    return o1[1] - o2[1]; // 끝점 비교
                } else { // 그렇지 않으면 시작점 비교
                    return o1[0] - o2[0];
                }
            }
        });

        int start = lines[0][0];
        int end = lines[0][1];

        int len = end - start;

        for (int i = 1; i < n; i++) {
            if (start <= lines[i][0] && lines[i][1] <= end) { // 기존 선 범위에서 그려지니까
                continue;
            } else if (lines[i][0] < end) { // 기존 선에서 시작한다면
                len += lines[i][1] - end; // 추가된 길이만 더하기
            } else { // 기존 선보다 큰 수라면 그 길이 더해주면 된다.
                // 이미 시작점 기준으로 오름차순으로 정렬했기 때문에 그 외는 아예 뒤쪽에 위치한 경우임
                len += lines[i][1] - lines[i][0];
            }

            // 다시 기준선 갱신
            start = lines[i][0];
            end = lines[i][1];
        }

        bw.write(String.valueOf(len));
        bw.close();
    }
}