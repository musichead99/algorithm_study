import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algorithm_16953 {

    static class Node {
        long value;
        int count;

        public Node(long value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bfs(a, b);

        System.out.println(min == Integer.MAX_VALUE ? -1 : (min + 1));
    }

    public static void bfs(int start, int end) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.value == end) { // b에 도달했다면 연산 횟수 비교 후 갱신
                min = Math.min(min, cur.count);
            }

            long multedValue = cur.value * 2; // 2를 곱한 수
            if(multedValue <= end) {
                q.add(new Node(multedValue, cur.count + 1));
            }

            long addedValue = cur.value * 10 + 1; // 뒤에 1을 추가한 수
            if(addedValue <= end) {
                q.add(new Node(addedValue, cur.count + 1));
            }
        }
    }
}
