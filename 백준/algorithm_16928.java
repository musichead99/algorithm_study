import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class algorithm_16928 {

    static class Node {
        int x;
        int count;

        public Node(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }

    /* 뱀과 사다리 정보는 O(1)로 접근할 수 있게 HashMap으로 처리 */
    static Map<Integer, Integer> snake = new HashMap<>();
    static Map<Integer, Integer> ladder = new HashMap<>();
    static int[] visited = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            snake.put(start, end);
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ladder.put(start, end);
        }

        bfs(1);

        System.out.println(visited[100]);

    }

    public static void bfs(int start) {
        Queue<Node> q = new LinkedList<>();

        Arrays.fill(visited, Integer.MAX_VALUE);
        q.add(new Node(start, 0));
        visited[1] = 0;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i = 1; i < 7; i++) {
                int nx = cur.x + i; // 주사위를 굴려서 갈 칸
                int newCount = cur.count + 1; // 해당 칸까지 이동하는데 주사위를 굴린 횟수

                if(nx <= 100) { // 주사위를 굴려서 갈 칸이 맵을 넘어가는지 체크

                    if(snake.containsKey(nx)) { // 해당 칸에 사다리나 뱀이 있는지 체크 후 갱신
                        nx = snake.get(nx);
                    } else if(ladder.containsKey(nx)) {
                        nx = ladder.get(nx);
                    } 

                    // 갈 칸까지의 주사위 횟수가 기존에 저장된 횟수보다 적다면 갱신
                    if(visited[nx] > newCount) {
                        q.add(new Node(nx, newCount));
                        visited[nx] = newCount;
                    }
                }
            }
        }
    }
}