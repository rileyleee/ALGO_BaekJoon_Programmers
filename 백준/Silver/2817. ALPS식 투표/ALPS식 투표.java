import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int staff = sc.nextInt();

        float[][] votes = new float[26][16];

        // 0열 = 총 득표 수
        // 15열 = 받은 칩 수

        for (int i = 0; i < staff; i++) {
            char staffName = sc.next().charAt(0);
            int votesNum = sc.nextInt();

            if (votesNum >= x * 0.05) { // 득표 수가 5% 인 경우에만 값 넣기
                votes[staffName - 'A'][0] = votesNum;
            }
        }

        // 1부터 14로 나눈 실수 구하기
        for (int s = 0; s < 26; s++)
            for (int i = 1; i <= 14; i++) {
                votes[s][i] = (float) (votes[s][0] / i);
            }

        //리스트에 값을 넣고 큰 순서대로 칩 부여

        List<Float> scores = new ArrayList<>();

        for (int s = 0; s < 26; s++) {
            if (votes[s][0] == 0.0) continue;
            for (int i = 1; i <= 14; i++) {
                scores.add(votes[s][i]);
            }
        }

        Collections.sort(scores, Collections.reverseOrder());

        for (int i = 0; i < 14; i++) {
            for (int s = 0; s < 26; s++) {
                if (votes[s][0] != 0.0) {
                    for (int j = 1; j <= 14; j++) {
                        if (votes[s][j] == scores.get(i)) {
                            votes[s][15] += 1.0;
                            break;
                        }
                    }

                }
            }
        }

        StringBuilder sb = new StringBuilder();
        
        // 값 출력
        for (int s = 0; s < 26; s++) {
            if (votes[s][0] == 0.0) continue;
            sb.append((char)(s + 65)).append(" " + (int) votes[s][15] + "\n");
        }

        System.out.println(sb);


    }
}