import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class algorithm_1261 {

    private static int n;
    private static int m;
    private static int[][] map;
    private static int[][] visited;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(tmp.charAt(j));
            }
        }

        visited[0][0] = 0;
        bfs(0, 0, 0);

        System.out.println(visited[n - 1][m - 1]);
    }

    /* 0-1 bfs */
    private static void bfs(int x, int y, int count) {
        Deque<Node> dq = new LinkedList<>();
        dq.add(new Node(0, 0, 0));
        
        while(!dq.isEmpty()) {
            Node cur = dq.pollFirst();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < n && nx > -1 && ny < m && ny > -1 && cur.count + map[nx][ny] < visited[nx][ny]) {
                    visited[nx][ny] = cur.count + map[nx][ny];

                    if(map[nx][ny] == 1) { // 가중치가 1이었다면 뒤에
                        dq.addLast(new Node(nx, ny, cur.count + 1));
                    } else { // 0이었다면 앞에
                        dq.add(new Node(nx, ny, cur.count));
                    }
                }
            }
        }
    }
}
