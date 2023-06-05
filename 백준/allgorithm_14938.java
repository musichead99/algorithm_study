import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* 서강그라운드 */
public class allgorithm_14938 {

    private static class Node implements Comparable<Node> {
        int num; // 노드 번호
        int cost; // 비용

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }


    private static int[] itemCount; // 각 구역에 있는 아이템 수
    private static ArrayList<ArrayList<Node>> map = new ArrayList<>();
    private static int[] visited; // 방문 배열

    private static final int INF = 100000000; // 최댓값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 지역의 개수
        int m = Integer.parseInt(st.nextToken()); // 예은이의 수색범위
        int r = Integer.parseInt(st.nextToken()); // 길의 개수
        itemCount = new int[n + 1];
        visited = new int[n + 1];

        /* 각 지역마다 아이템 개수 입력 */
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++) {
            itemCount[i] = Integer.parseInt(st.nextToken());
        }

        /* map graph초기화 */
        for(int i = 0; i < n + 1; i++) {
            map.add(new ArrayList<>());
        }

        /* map graph 입력 */
        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map.get(start).add(new Node(end, cost));
            map.get(end).add(new Node(start, cost));
        }

        /* 각 지역에 떨어졌을 때 얻을 수 있는 아이템의 최대 개수 계산 */
        int result = 0;
        for(int i = 1; i < n + 1; i++) {
            Arrays.fill(visited, INF); // 방문 배열 초기화
            dijkstra(i);

            int sum = calculateItemCount(m); 
            result = result < sum ? sum : result;
        }

        System.out.println(result);
    }

    /* start부터 각 지역까지의 최단거리 계산 */
    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        visited[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            for(Node node : map.get(cur.num)) {
                if(node.cost + cur.cost < visited[node.num]) {
                    visited[node.num] = node.cost + cur.cost;
                    pq.add(new Node(node.num, node.cost + cur.cost));
                }
            }
        }
    }

    /* 다익스트라 알고리즘 적용 후 각 지역까지의 최단거리를 확인하고 얻을 수 있는 아이템 계산 */
    private static int calculateItemCount(int m) {

        int sum = 0;
        for(int i = 1; i < visited.length; i++) {
            if(visited[i] <= m) {
                sum += itemCount[i];
            }
        }

        return sum;
    }
}
