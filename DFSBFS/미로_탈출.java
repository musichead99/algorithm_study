package algorithm_study.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        /* 사용자로부터 맵을 입력받아 초기화 */
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        /* 방문 함수 초기화 */
        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        /* bfs을 통해 길찾기 */
        bfs(map, new Node(0,0), visited);
    }

    /* bfs 함수 */
    private static void bfs(int[][] graph, Node start, boolean[][] visited) {
        Queue<Node> queue = new LinkedList<>();

        /* 시작 노드를 큐에 넣고 시작 지점에 방문표시를 함 */
        queue.add(start);
        visited[start.x][start.y] = true;

        /* 해당 좌표에서 상하좌우를 탐색하기 위한 이동값들 */
        Node[] steps = {new Node(1,0), new Node(-1,0), new Node(0,1), new Node(0,-1)};

        /* bfs 시작 */
        while(!queue.isEmpty()) {
            Node temp = queue.poll(); // queue로부터 노드 꺼내기

            /* 상하좌우 탐색 */
            for(Node step : steps) {

                /* 다음에 이동할 좌표 */
                int nx = step.x + temp.x;
                int ny = step.y + temp.y;

                /* 이동할 좌표에 대한 검증(맵을 벗어나지는 않는가, 이동할 수 없는 벽인가, 이미 방문했는가 등) */
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if(graph[nx][ny] == 0) {
                    continue;
                }
                if(visited[nx][ny] == true) {
                    continue;
                }

                /* 검증이 통과되면 해당 좌표에 이동한 거리를 추가, 해당 좌표를 queue에 삽입, 방문표시 */
                graph[nx][ny] = graph[temp.x][temp.y] + 1;
                queue.add(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }

        System.out.println(graph[N-1][M-1]);
    }
}
