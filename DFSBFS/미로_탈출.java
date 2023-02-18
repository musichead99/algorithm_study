package algorithm_study.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로_탈출 {

    private static class Node {
        public int x;
        public int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        /* 미로 입력받기 */
        int[][] map = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i + 1][j + 1] = Character.getNumericValue(tmp.charAt(j));
            }
        }

        /* bfs를 수행한 결과를 출력 */
        System.out.println(bfs(map, new Node(1, 1)));
    }

    /* bfs를 수행하는 메소드 */
    public static int bfs(int[][] map, Node start) {
        Queue<Node> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            Node tmp = q.poll();

            int x = tmp.x;
            int y = tmp.y;

            /* 현재 좌표를 기준으로 상하좌우의 좌표들을 탐색 */
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                /* 탐색한 좌표가 맵을 벗어난다면 무시 */
                if(nx < 1 || ny < 1 || nx > n || ny > m) {
                    continue;
                }

                /* 탐색한 좌표에 괴물이 있다면 무시 */
                if(map[nx][ny] == 0) {
                    continue;
                }

                /* 좌표의 값이 1(이동 가능한 통로)일 때만 큐에 넣고 거리 값 업데이트 */
                if(map[nx][ny] == 1) {
                    q.add(new Node(nx, ny));
                    map[nx][ny] += map[x][y];
                }
            }
        }

        /* 탈출 지점까지 계산한 거리값 출력 */
        return map[n][m];
    }
}
