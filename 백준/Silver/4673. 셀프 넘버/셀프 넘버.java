public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        int[] list = new int[10001];

        int n = 1;

        while (n <= 10000) {

            int num = n;

            String letters = String.valueOf(n);

            for (int i = 0; i < letters.length(); i++) {
                num += (int) letters.charAt(i) - 48;
            }
            if (num <= 10000) {
                list[num] = 1;
            }
            n++;
        }

        for(int i =1; i<list.length; i++){
            if(list[i]==0){
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}