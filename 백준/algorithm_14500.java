import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_14500 {

    static boolean[][] visited;
    static int[][] map;
    static int n;
    static int m;
    static int max = Integer.MIN_VALUE;
    /* 상하좌우 순서 */
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(max);

    }

    public static void dfs(int r, int c, int depth, int sum) {
        if(depth == 4) {
            max = Math.max(sum, max);
            return;
        }

        for(int i = 0; i < 4 ; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(check(nr, nc)) {

                if(depth == 2) {
                    visited[nr][nc] = true;
                    dfs(r, c, depth + 1, sum + map[nr][nc]);
                    visited[nr][nc] = false;
                }

                visited[nr][nc] = true;
                dfs(nr, nc, depth + 1, sum + map[nr][nc]);
                visited[nr][nc] = false;
            }
        }
    }

    private static boolean check(int r, int c) {
        return r < n && r > -1 && c < m && c > -1 && !visited[r][c];
    }
}
