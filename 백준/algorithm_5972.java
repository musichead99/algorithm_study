import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class algorithm_5972 {

    private static class Node implements Comparable<Node> {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    private static int n;
    private static int m;
    private static ArrayList<ArrayList<Node>> map = new ArrayList<>();
    private static int[] costs;
    private static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        costs = new int[n + 1];
        Arrays.fill(costs, INF);

        for(int i = 0; i < n + 1 ; i++) {
            map.add(new ArrayList<Node>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map.get(start).add(new Node(end, cost));
            map.get(end).add(new Node(start, cost));
        }

        dijkstra();

        System.out.println(costs[n]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        costs[1] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            for(Node node : map.get(cur.num)) {
                if(node.cost + cur.cost < costs[node.num]) {
                    pq.add(new Node(node.num, node.cost + cur.cost));
                    costs[node.num] = node.cost + cur.cost;
                }
            }
        }
    }
}
