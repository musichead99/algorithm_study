package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 미로 탐색 */
public class algorithm_2178 {

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] visited = new int[n][m];

        for(int i= 0; i < n; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(tmp.charAt(j));
            }
        }

        bfs(0, 0, map, visited);

        System.out.println(visited[n - 1][m - 1]);

    }

    /* 방문 배열에 해당 위치까지의 최단 거리를 적는다 */
    public static void bfs(int x, int y, int[][] map, int[][] visited) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = 1;

        while(!q.isEmpty()) {
            Node tmp = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx < n && ny < m && nx > -1 && ny > -1 && map[nx][ny] != 0 && visited[nx][ny] == 0) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = visited[tmp.x][tmp.y] + 1;
                }
            }
        }
    }
}
