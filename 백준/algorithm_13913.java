import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class algorithm_13913 {

    private static class Node {
        int x;
        int time;
        int operation; // -2 : 한 번도 들르지 않음, -1 : 시작, 0 : -1, 1 : +1, 2 : *2

        public Node(int x, int time, int operation) {
            this.x = x;
            this.time = time;
            this.operation = operation;
        }
    }

    private static int n;
    private static int k;
    private static final int INF = 1000001;
    private static Node[] visited = new Node[INF];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Arrays.fill(visited, new Node(-1, INF, -2));

        bfs(n);

        System.out.println(visited[k].time);
        tracking();
    }

    private static void bfs(int start) {
        Queue<Node> q = new LinkedList<>(); 
        Node st = new Node(start, 0, -1);
        q.add(st);
        visited[start] = st;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            int nx = cur.x - 1;
            if(nx >= 0 && nx < INF && visited[nx].time > cur.time+1) {
                Node next = new Node(nx, cur.time + 1, 0);
                visited[nx] = next;
                q.add(next);
            }

            nx = cur.x + 1;
            if(nx >= 0 && nx < INF && visited[nx].time > cur.time+1) {
                Node next = new Node(nx, cur.time + 1, 1);
                visited[nx] = next;
                q.add(next);
            }

            nx = cur.x * 2;
            if(nx >= 0 && nx < INF && visited[nx].time > cur.time+1) {
                Node next = new Node(nx, cur.time + 1, 2);
                visited[nx] = next;
                q.add(next);
            }
        }
    }

    private static void tracking() {
        Node cur = visited[k];
        Stack<Integer> s = new Stack<>();

        while(cur.operation != -1) {
            s.push(cur.x);

            switch(cur.operation) {
                case 0:
                    cur = visited[cur.x + 1];
                    break;
                case 1:
                    cur = visited[cur.x - 1];
                    break;
                case 2:
                    cur = visited[cur.x / 2];
                    break;
                default:
                    System.exit(0);
            }
        }
        s.push(cur.x);

        while(!s.empty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }
}
