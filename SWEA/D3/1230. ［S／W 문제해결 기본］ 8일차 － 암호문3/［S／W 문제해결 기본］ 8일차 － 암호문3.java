import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        for (int t = 0; t < 10; t++) {
            int length = Integer.parseInt(br.readLine());
 
            String originCode = br.readLine();
            StringTokenizer st = new StringTokenizer(originCode);
 
            SinglyLinkedList list = new SinglyLinkedList();
 
            // 연결리스트에 원본 암호문 입력하기
            for (int o = 0; o < length; o++) {
                int oriCode = Integer.parseInt(st.nextToken());
                list.addToEnd(oriCode);
            }
 
            // 명령어 갯수 받기
            int comNum = Integer.parseInt(br.readLine());
 
            // 명령어 수 만큼 반복문 돌면서 수행하기
            String command = br.readLine();
            st = new StringTokenizer(command);
            for (int c = 0; c < comNum; c++) {
                String cType = st.nextToken();
                switch (cType) {
                case "I":
                    int Ix = Integer.parseInt(st.nextToken());
                    int Iy = Integer.parseInt(st.nextToken());
                    if (Ix == 0) {
                        int Is = Integer.parseInt(st.nextToken());
                        list.addToStart(Is);
                        list.GetLocation(1);
                        for (int i = 1; i < Iy; i++) {
                            Is = Integer.parseInt(st.nextToken());
                            list.addAfter(i, Is);
                        }
                    } else {
                        list.GetLocation(Ix);
                        for (int i = 0; i < Iy; i++) {
                            int Is = Integer.parseInt(st.nextToken());
                            list.addAfter(Ix + i, Is);
                        }
                    }
                    break;
                case "D":
                    int Dx = Integer.parseInt(st.nextToken());
                    int Dy = Integer.parseInt(st.nextToken());
                    list.GetLocation(Dx);
                    for (int i = 0; i < Dy; i++) {
                        list.deleteAfter(Dx);
                    }
                    break;
                case "A":
                    int Ay = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < Ay; i++) {
                        int As = Integer.parseInt(st.nextToken());
                        list.addToEnd(As);
                    }
                    break;
                }
            }
            System.out.print("#" + (t + 1) + " ");
            list.printList();
        }
    }
 
    public static class Node {
        public int code;
        public Node next;
 
        public Node(int code) {
            this.code = code;
            this.next = null;
        }
    }
 
    public static class SinglyLinkedList {
        public Node head;
 
        public SinglyLinkedList() {
        }
 
        public void addToEnd(int code) {
            Node n = new Node(code);
            if (head == null) {
                head = n;
            } else {
                Node curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = n;
            }
        }
 
        public void addToStart(int code) {
            Node n = new Node(code);
            n.next = head;
            head = n;
        }
 
        public Node getNode(int target) {
            Node curr = head;
 
            while (curr != null) {
                if (curr.code == target) {
                    return curr;
                }
                curr = curr.next;
            }
            return null;
        }
 
        public Node GetLocation(int loc) {
            Node curr = head;
            int cnt = 1;
            while (curr != null) {
                if (loc == cnt) {
                    return curr;
                }
                curr = curr.next;
                cnt++;
            }
            return null;
        }
 
        public void addAfter(int loc, int code) {
            Node targetNode = GetLocation(loc);
            if (targetNode != null) {
                Node n = new Node(code);
                n.next = targetNode.next;
                targetNode.next = n;
            }
        }
 
        public void deleteAfter(int loc) {
            Node targetNode = GetLocation(loc);
            if (targetNode != null) {
                Node deNode = targetNode.next;
                targetNode.next = deNode.next;
            }
        }
 
        public void printList() {
            Node curr = head;
            for (int p = 0; p < 10; p++) {
                System.out.print(curr.code + " ");
                curr = curr.next;
            }
            System.out.println();
        }
    }
}