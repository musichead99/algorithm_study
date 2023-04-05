package algorithm_study.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class algorithm_10026 {

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[] count = new int[2];
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int n;
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        /* 적록색맹이 아닌 사람이 보는 구역의 수 카운트 */
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(bfs(i, j)) count[0]++;
            }
        }

        /* 적록색맹이 보는 시야로 영역을 바꿔준다.(R -> G) */
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 'R') map[i][j] = 'G';
            }
        }

        /* 적록색맹인 사람이 보는 구역의 수 카운트 */
        visited = new boolean[n][n]; // 방문 배열 초기화
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(bfs(i, j)) count[1]++;
            }
        }

        System.out.println(count[0] + " " + count[1]);

    }

    public static boolean bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();

        if(visited[r][c]) return false;

        q.add(new Node(r, c));
            visited[r][c] = true;

        char color = map[r][c];

        while(!q.isEmpty()) {
            Node tmp = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx > -1 && ny > -1 && nx < n && ny < n && !visited[nx][ny]) {
                    if(color == map[nx][ny]) { // 맨 처음에 큐에 넣은 노드의 색과 같은 색일 때만 영역이므로 넣는다.
                        q.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return true;
    }
}
