import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static class numSet implements Comparable<numSet>{
        int originNum;
        int fixedNum;
        public numSet(int a, int b){
            originNum = a;
            fixedNum =b;
        }

        @Override
        public int compareTo(numSet target) {

            if(this.fixedNum!=target.fixedNum){
                return Integer.compare(this.fixedNum, target.fixedNum);
            }else{
                return Integer.compare(this.originNum, target.originNum);
            }
        }

        @Override
        public String toString(){
            return Integer.toString(this.originNum);
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n  = sc.nextInt();

        PriorityQueue<numSet> mh = new PriorityQueue<>();

        for(int i =0; i<n; i++){
            int thisNum = sc.nextInt();

            if(thisNum!=0){
                mh.add(new numSet(thisNum, Math.abs(thisNum)));
            }else{
                if(!mh.isEmpty()){
                sb.append(mh.poll()).append("\n");
                }else{
                    sb.append("0\n");
                }
            }
        }

        System.out.println(sb.toString());

    }
}