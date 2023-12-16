import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine(); //sc.next() 는 공백에서 끊어서 읽음

        // System.out.println(s);


        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '<') {
                sb.append(s.charAt(i));
                //System.out.println(s.charAt(i) + "붙였어요" + " i는 " + i);
                i++;
                while (s.charAt(i) != '>') {
                    sb.append(s.charAt(i));
                    //System.out.println(s.charAt(i) + "붙였어요" + " i는 " + i);
                    i++;
                }
                if (s.charAt(i) == '>') {
                    sb.append(s.charAt(i));
                    //System.out.println(s.charAt(i) + "붙였어요" + " i는 " + i);
                    i++;
                }
            } else {
                StringBuilder reverseSb = new StringBuilder();
                if (s.charAt(i) != ' ') { // 그 다음 나온 문자가 공백이 아니라면
                    while (i != s.length() && s.charAt(i) != ' ') {

                        if (s.charAt(i) == '<') {
                            break;
                        } else {
                            //System.out.println(s.charAt(i) + "역순되기 위해 붙였어요" + " i는 " + i);
                            reverseSb.append(s.charAt(i)); // 공백 나오기 전까지 계속 담고
                            i++;
                        }
                    }
                    String reversedS = reverseSb.reverse().toString();
                    sb.append(reversedS);
                    //System.out.println(reversedS + "거꾸로 만들어서 붙였어요" + " i는 " + i);
                } else { // 공백이라면
                    sb.append(' ');
                    //System.out.println(s.charAt(i) + "공백 붙였어요" + " i는 " + i);
                    i++;
                }
            }
        }
        System.out.println(sb.toString());
    }
}