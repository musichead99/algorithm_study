import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class algorithm_1916 {

    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);

    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node tmp = pq.poll();

            if(!visited[tmp.idx]) { // 방문 표시
                visited[tmp.idx] = true;
            }

            if(dist[tmp.idx] < tmp.cost) { // 갱신할 필요가 없다
                continue;
            }

            for(Node node : graph.get(tmp.idx)) {
                if(!visited[node.idx] && dist[node.idx] > dist[tmp.idx] + node.cost) {
                    dist[node.idx] = dist[tmp.idx] + node.cost;
                    pq.add(new Node(node.idx, dist[node.idx]));
                } 
            }
        }
    }
}