import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algorithm_2206 {

    private static class Node {
        int x;
        int y;
        int status;

        public Node(int x, int y, int status) {
            this.x = x;
            this.y = y;
            this.status = status;
        }
    }

    private static int[][] map;
    private static int[][][] visited;
    private static int n;
    private static int m;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[2][n][m];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        bfs(0, 0);

        int result = Math.min(visited[0][n - 1][m - 1], visited[1][n - 1][m - 1]);
        
        System.out.println(result == INF ? -1 : result);

    }

    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(visited[i][j], INF);
            }
        }

        q.offer(new Node(x, y, 1));
        visited[1][x][y] = 1;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int status = cur.status;

                if(nx >= n || nx < 0 || ny >= m || ny < 0) { // 범위 체크
                    continue;
                }

                if(map[nx][ny] == 1) { // 벽이라면?
                    if(status != 1) { // 부술 수 있는지 체크
                        continue;
                    }

                    if(visited[status - 1][nx][ny] > visited[status][cur.x][cur.y] + 1) {
                        q.offer(new Node(nx, ny, status - 1));
                        visited[status - 1][nx][ny] = visited[status][cur.x][cur.y] + 1;
                    }

                } else { // 벽 아니라면
                    if(visited[status][nx][ny] > visited[status][cur.x][cur.y] + 1) {
                        q.offer(new Node(nx, ny, status));
                        visited[status][nx][ny] = visited[status][cur.x][cur.y] + 1;
                    }
                }
            }
        }
    }
}
