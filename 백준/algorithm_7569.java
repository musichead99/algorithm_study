package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algorithm_7569 {
    static class Node {
        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};

    static int[][][] map;
    static int n;
    static int m;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][n][m];
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        bfs();

        
        int result = Integer.MIN_VALUE;
        Loop:
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(map[i][j][k] != 0) {
                        result = Math.max(result, map[i][j][k]);
                    } else {
                        result = 0;
                        break Loop;
                    }
                }
            }
        }

        /* 일수를 출력할 때는 1을 빼준다 */
        System.out.println(result - 1);

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(map[i][j][k] == 1) {
                        q.add(new Node(i,j,k));
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            Node tmp = q.poll();

            for(int i = 0; i < 6; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                int nz = tmp.z + dz[i];

                if(nx > -1 && nx < h && ny > -1 && ny < n && nz > -1 && nz < m) {
                    if(map[nx][ny][nz] == 0) {
                        /* 걸린 일수를 맵에 카운트 */
                        map[nx][ny][nz] = map[tmp.x][tmp.y][tmp.z] + 1;
                        q.add(new Node(nx, ny, nz));
                    }
                }
            }
        }
    }
}