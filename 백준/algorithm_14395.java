import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algorithm_14395 {

    private static class Node {
        long num;
        String operations;

        public Node(long num, String operations) {
            this.num = num;
            this.operations = operations;
        }   
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long s = Long.parseLong(st.nextToken());
        long t = Long.parseLong(st.nextToken());

        if(s == t) {
            System.out.println(0);
            System.exit(0);
        }

        bfs(s, t);

        System.out.println(-1);
    }

    private static void bfs(long s, long t) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, ""));
        HashSet<Long> set = new HashSet<>();

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.num == t) {
                System.out.println(cur.operations);
                System.exit(0);
            }

            long next = cur.num * cur.num;
            if(next >= 1 && next <= t && !set.contains(next)) {
                q.add(new Node(next, cur.operations + "*"));
                set.add(next);
            }

            next = cur.num + cur.num;
            if(next >= 1 && next <= t && !set.contains(next)) {
                q.add(new Node(next, cur.operations + "+"));
                set.add(next);
            }

            next = cur.num - cur.num;
            if(next >= 1 && next <= t && !set.contains(next)) {
                q.add(new Node(next, cur.operations + "-"));
                set.add(next);
            }

            if(cur.num != 0) {
                next = cur.num / cur.num;
                if(next >= 1 && next <= t && !set.contains(next)) {
                    q.add(new Node(next, cur.operations + "/"));
                    set.add(next);
                }
            }
        }
    }
}