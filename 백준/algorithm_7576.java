package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algorithm_7576 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int m;
    static int n;
    static int[][] map;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        int result = Integer.MIN_VALUE;
        Loop:
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    result = 0;
                    break Loop;
                }
                else {
                    result = Math.max(result, map[i][j]);
                }
            }
        }

        System.out.println(result - 1);

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1) q.add(new Node(i, j));
            }
        }

        while(!q.isEmpty()) {
            Node tmp = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx > -1 && nx < n && ny > -1 && ny < m) {
                    if(map[nx][ny] == 0) {
                        map[nx][ny] = map[tmp.x][tmp.y] + 1;
                        q.add(new Node(nx, ny));
                    }
                }
            }

        }
    }
}
