import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 10; t++) {
			int N = 100;
			int testNum = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for (int r = 0; r < arr.length; r++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str); // 토큰나이징 먼저 하고 내부 포문 돌기
				for (int c = 0; c < arr[r].length; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			// 가로 세로 더해서 최대값 새로운 배열에 넣기
			int[] maxNum = new int[N * 2 + 2];
			int rSum = 0;
			int cSum = 0;
			int i = 0;
			for (int r = 0; r < arr.length; r++) {
				rSum = 0;
				cSum = 0;
				for (int c = 0; c < arr[r].length; c++) {
					rSum += arr[r][c];
					cSum += arr[c][r];
				}
				maxNum[i] = rSum;
				maxNum[i + 100] = cSum;
				i++;
			}
			// 대각선 합 구하기
			int dSum1 = 0;
			int dSum2 = 0;
			for (int d = 0; d < arr.length; d++) {
				dSum1 += arr[d][d];
				dSum2 += arr[arr.length - 1 - d][d];
			}
			maxNum[N * 2] = dSum1;
			maxNum[N * 2 + 1] = dSum2;

			// 각 합 중 최댓값 구하기
			int max = -1;
			for (int m = 0; m < maxNum.length; m++) {
				if (maxNum[m] > max) {
					max = maxNum[m];
				}
			}
			System.out.println("#" + (testNum) + " " + max);
		}
	}
}