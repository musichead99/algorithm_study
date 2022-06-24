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

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        bfs(map, new Node(0,0), visited);
    }

    private static void bfs(int[][] graph, Node start, boolean[][] visited) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;
        Node[] steps = {new Node(1,0), new Node(-1,0), new Node(0,1), new Node(0,-1)};

        while(!queue.isEmpty()) {
            Node temp = queue.poll();

            for(Node step : steps) {
                int nx = step.x + temp.x;
                int ny = step.y + temp.y;

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if(graph[nx][ny] == 0) {
                    continue;
                }
                if(visited[nx][ny] == true) {
                    continue;
                }

                graph[nx][ny] = graph[temp.x][temp.y] + 1;
                queue.add(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }

        System.out.println(graph[N-1][M-1]);
    }
}
