import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_4963 {

    private static int w, h;
    private static int[][] map;
    private static boolean[][] visited;

    private static int[] dx = {1, -1, 0, 0, -1, 1, 1, -1};
    private static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= h || ny >= w || nx < 0 || ny < 0) {
                continue;
            }

            if(map[nx][ny] == 1 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}