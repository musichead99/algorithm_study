import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 숨바꼭질 3 */
public class algorithm_13549 {

    static class Node {
        int x;
        int sec;

        public Node(int x, int sec) {
            this.x = x;
            this.sec = sec;
        }
    }

    static int n;
    static int m;
    static int[] dist = new int[100001];
    static int[] ops = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, Integer.MAX_VALUE);

        bfs(n);

        System.out.println(dist[m]);
    }

    /* BFS */
    public static void bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()) {
            Node tmp = q.poll();

            /* 1초씩 걸리는 한 칸 앞으로 또는 한 칸 뒤로가기 */
            for(int op : ops) {
                int nx = tmp.x + op;
                if(nx > -1 && nx < 100001 && dist[nx] > tmp.sec + 1) {
                    q.add(new Node(nx, tmp.sec + 1));
                    dist[nx] = tmp.sec + 1;
                }
            }

            /* 0초가 걸리는 순간이동 */
            int nx = tmp.x * 2;
            if(nx > -1 && nx < 100001 && dist[nx] > tmp.sec) {
                q.add(new Node(nx, tmp.sec));
                dist[nx] = tmp.sec;
            }
        }
    }
}
