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

public class 전보 {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static int[] d;
    static int INF = (int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /* 도시의 개수 N, 통로의 개수 M, 메시지를 보내고자 하는 도시 C가 주어짐 */
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        /* 결과값을 저장할 배열 초기화 */
        d = new int[N + 1];
        Arrays.fill(d, INF);

        /* 그래프 초기화 */
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()); // 시작점
            int Y = Integer.parseInt(st.nextToken()); // 끝점
            int Z = Integer.parseInt(st.nextToken()); // 간선의 비용

            graph.get(X).add(new Node(Y, Z));
        }

        dijkstra(C);

        int count = 0;
        int longDistance = 0;

        for(int i = 1; i <= N; i++) {
            if(d[i] < INF) {
                count++;
                longDistance = Math.max(d[i], longDistance);
            }
        }

        System.out.println((count - 1) + " " + longDistance);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        /* 시작점에서 시작점으로의 최단거리는 0이다. */
        d[start] = 0;

        /* 우선순위 큐에 삽입 */
        pq.offer(new Node(start, 0));

        /* 우선순위 큐가 빌 때까지 반복 */
        while(!pq.isEmpty()) {
            Node node = pq.poll();

            int dist = node.getDistance();
            int now = node.getIndex();

            if(d[now] < dist) continue;

            for(Node tmp : graph.get(now)) {
                int cost = d[now] + tmp.getDistance();

                if(cost < d[tmp.getIndex()]) {
                    d[tmp.getIndex()] = cost;
                    pq.offer(new Node(tmp.getIndex(), cost));
                }
            }
        }
    }
}
