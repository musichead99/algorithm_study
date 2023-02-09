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

    static int safeAreaCount = Integer.MIN_VALUE;
    static int[][] map;
    static int N;
    static int M;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(safeAreaCount);
    }

    private static void dfs(int count) {
        if(count == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        int count = 0;

        /* 우선 연구소에서 바이러스가 위치한 좌표들을 큐에 삽입 */
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }

        /* 맵을 변경하지 않기 위해 복사 */
        int[][] demoMap = new int[N][M];

        for(int i = 0; i < N; i++) {
            demoMap[i] = map[i].clone();
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i = 0; i < 4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];

                if(x >= 0 && y >= 0 && x < N && y < M) {
                    if(demoMap[x][y] == 0) {
                        demoMap[x][y] = 2;
                        queue.add(new Node(x, y));
                    }
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(demoMap[i][j] == 0) {
                    count++;
                }
            }
        }

        safeAreaCount = safeAreaCount < count ? count : safeAreaCount;
    }
}
