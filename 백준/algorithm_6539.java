import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algorithm_6539 {

    private static class Node {
        int x;
        int y;
        int z;
        int minute;

        public Node(int x, int y, int z, int minute) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.minute = minute;
        }
    }

    private static char[][][] building;
    private static boolean[][][] visited;
    private static int minCount;
    private static Node startNode;
    private static int l, r, c;

    private static int[] dx = {-1, 1, 0, 0, 0, 0};
    private static int[] dy = {0, 0, -1, 1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, -1, 1};

    private static final String ESCAPE_VALUE_STRING = "Escaped in %d minute(s).";
    private static final String ESCAPE_FAILED_STRING = "Trapped!";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            minCount = Integer.MAX_VALUE;

            if(exitCheck(l, r, c)) {
                break;
            }

            building = new char[l][r][c];
            visited = new boolean[l][r][c];

            for(int i = 0; i < l; i++) {
                for(int j = 0; j < r; j++) {
                    String temp = br.readLine();
                    for(int k = 0; k < c; k++) {
                        building[i][j][k] = temp.charAt(k);

                        if(building[i][j][k] == 'S') {
                            startNode = new Node(i, j, k, 0);
                        }
                    }
                }
                br.readLine(); // 쓰래기값 처리
            }

            bfs();

            if(minCount == Integer.MAX_VALUE) {
                sb.append(ESCAPE_FAILED_STRING + "\n");
            } else {
                sb.append(String.format(ESCAPE_VALUE_STRING, minCount) + "\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean exitCheck(int l, int r, int c) {
        if(l == 0 && r == 0 && c == 0) {
            return true;
        }

        return false;
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(startNode);
        visited[startNode.x][startNode.y][startNode.z] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(building[cur.x][cur.y][cur.z] == 'E') {
                minCount = Math.min(minCount, cur.minute);
            }

            for(int i = 0; i < 6; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];

                if(boundaryCheck(nx, ny, nz) && building[nx][ny][nz] != '#' && !visited[nx][ny][nz]) {
                    visited[nx][ny][nz] = true;
                    q.add(new Node(nx, ny, nz, cur.minute + 1));
                }
            }
        }
    }

    private static boolean boundaryCheck(int nx, int ny, int nz) {
        if(nx < 0 || ny < 0 || nz < 0 || nx >= l || ny >= r || nz >= c) {
            return false;
        }

        return true;
    }
}
