package algorithm_study.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node o) {
        return this.distance - o.distance;
    }
}

public class practice9_2 {
    static final int INF = (int)1e9;
    public static int N, M;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] d;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        d = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }

        /* a번 노드에서 b번 노드로 가는 비용이 c라는 의미 */
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b,c));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        for (int i = 1; i <= N; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(d[i]);
            }
        }

    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[start] = 0;

        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node tmp = pq.poll();

            int dist = tmp.getDistance();
            int now = tmp.getIndex();

            if(d[now] < dist) continue;

            for(Node node : graph.get(now)) {
                int cost = d[now] + node.getDistance();

                if(cost < d[node.getIndex()]) {
                    d[node.getIndex()] = cost;
                    pq.offer(new Node(node.getIndex(), cost));
                }
            }
        }
    }
}
