import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class algorithm_2346 {
    static class Node {
        int num;
        int target;

        public Node(int num, int target) {
            this.num = num;
            this.target = target;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Node> dq = new ArrayDeque<>(); // 데크의 또 다른 구현체**
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < n + 1; i++) {
            int target = Integer.parseInt(st.nextToken());
            dq.add(new Node(i, target));
        }

        while(!dq.isEmpty()) {
            Node cur = dq.pollFirst();
            sb.append(cur.num + " ");

            if(dq.isEmpty()) {
                break;
            }

            if(cur.target < 0) {
                for(int j = 0; j < -cur.target; j++) {
                    Node tmp = dq.pollLast();
                    dq.addFirst(tmp);
                }
            }

            if(cur.target > -1) {
                for(int j = 1; j < cur.target; j++) {
                    Node tmp = dq.pollFirst();
                    dq.addLast(tmp);
                }
            }
        }

        sb.append("\n");
        System.out.println(sb);
    }
}
