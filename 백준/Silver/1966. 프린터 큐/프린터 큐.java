import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<int[]> qu = new LinkedList<>(); // qu의 타입은 int형 배열임
		int test = sc.nextInt();
		for (int t = 0; t < test; t++) {
			qu.clear();
			int docNum = sc.nextInt();
			int docIdx = sc.nextInt();
			for (int d = 0; d < docNum; d++) { // d는 인덱스
				qu.add(new int[] { d, sc.nextInt() });
			}
			int order = 0;
			while (true) {
				boolean doc = true;
				int[] check = qu.peek();
				for (int[] q : qu) {
					if (check[1] < q[1]) { // 다른 원소의 우선순위가 높으면
						doc = false;
						break;
					} // 다른 원소의 우선순위가 같거나 낮으면 true로 유지 -> 내가 먼저 나갈거야
				}
				if (doc) {
					order++; // 출력되는 원소 순서 매기기
					if (check[0] == docIdx) { // 찾던 원소면 멈추기
						break;
					} else {// 같지 않은 경우 출력해버림
						qu.poll();
					}
				} else { // 중요도가 낮은 원소는 맨 뒤에 추가해줌
					qu.offer(qu.poll());
				}
			}
			System.out.println(order);
		}
		sc.close();
	}
}