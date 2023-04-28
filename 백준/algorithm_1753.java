import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class algorithm_1753 {

    static class Node implements Comparable<Node>{
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int v;
    static int e;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v  = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        /* 그래프 선언 */
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        /* 방향 그래프 초기화 */
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
        }

        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(graph, dist, k);

        for(int i = 1; i < v + 1; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }

    public static void dijkstra(List<List<Node>> graph, int[] dist, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[v + 1];
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node tmp = pq.poll();

            if(visited[tmp.end]) continue;
            visited[tmp.end] = true;

            for(Node node : graph.get(tmp.end)) {
                int newWeight = node.weight + dist[tmp.end];
                if(newWeight < dist[node.end]) {
                    dist[node.end] = newWeight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}