package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algorithm_1012 {

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int n;
    private static int m;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        /* 테스트 케이스 수 만큼 반복 */
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][m];

            /* 배추의 좌표 입력 */
            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            int count = 0;
            for(int j = 0; j < n; j++) {
                for(int l = 0; l < m; l++) {
                    if(map[j][l] == 1) {
                        count++;
                        bfs(map, l, j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    /* bfs 함수 */
    public static void bfs(int[][] map, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        map[y][x] = 0;

        while(!q.isEmpty()) {
            Node tmp = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx > -1 && ny > -1 && nx < m && ny < n && map[ny][nx] == 1) {
                    q.add(new Node(nx, ny));
                    map[ny][nx] = 0;
                }
            }
        }
    }
}
