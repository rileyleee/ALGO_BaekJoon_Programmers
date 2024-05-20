import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 문자열 입력 받고
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        // 문자열 길이 만큼 스트링 배열 생성
        String[] suffixArr = new String[s.length()];

        // substring으로 반복하며 접미사 생성 + 배열에 입력
        for(int i = 0; i<suffixArr.length; i++){
            suffixArr[i] = s.substring(i, suffixArr.length);
            //System.out.println(suffixArr[i]);
        }
        // 배열 정렬
        Arrays.sort(suffixArr);

        StringBuilder sb = new StringBuilder();

        for(String str: suffixArr)
            sb.append(str+"\n");

        System.out.println(sb);
    }
}