import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algorithm_2589 {

    private static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    private static int n;
    private static int m;
    private static char[][] map;
    private static int count;
    private static int result = 0;

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for(int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(result);
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        count = 0;
        q.offer(new Node(x, y, 0));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 'W') {
                    continue;
                }

                q.offer(new Node(nx, ny, cur.count + 1));
                visited[nx][ny] = true;

                count = Math.max(count, cur.count + 1);
            }
        }

        result = Math.max(count, result);
    }

}
