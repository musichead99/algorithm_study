package algorithm_study.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {

    public int x;
    public int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 연구소 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static int safeArea = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        /* 맵 초기화 */
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(map, 0);

        System.out.println(safeArea);
    }

    /* 맵에 3개의 벽을 세우는 dfs 함수 */
    public static void dfs(int[][] map, int count) {
        if(count == 3) {
            bfs(map);
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(map, count + 1);
                    map[i][j] = 0; // 3개의 벽을 세우고 bfs까지 마무리하면 다음 벽들을 세우기 위해 벽을 초기화
                }
            }
        }
    }

    /* 바이러스가 맵에 퍼진 상황을 만들기 위한 bfs 메소드 */
    public static void bfs(int[][] map) {
        Queue<Node> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 2) {
                    q.add(new Node(i, j));
                }
            }
        }

        /* 맵을 변경하지 않기 위해 복사 */
        int[][] demoMap = new int[n][m];

        for(int i = 0; i < n; i++) {
            demoMap[i] = map[i].clone();
        }

        /* 맵에 바이러스가 퍼진 부분을 표시 */
        while(!q.isEmpty()) {
            Node tmp = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(demoMap[nx][ny] == 0) {
                        q.add(new Node(nx, ny));
                        demoMap[nx][ny] = 2;
                    }
                }
            }
        }

        /* 안전구역의 개수 카운트 */
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(demoMap[i][j] == 0) {
                    count++;
                }
            }
        }

        /* 기존의 안전구역의 개수와 새로 계산한 안전구역의 개수 중 더 많은 개수를 유지 */
        safeArea = Math.max(count, safeArea);
    }
}