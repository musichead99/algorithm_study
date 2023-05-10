package algorithm_study.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/* 아기상어 */
public class algorithm_16236 {

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int size;
        int dist;

        public Node(int x, int y, int size, int dist) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.dist = dist;
        }

        public int compareTo(Node o) {
            if(this.dist - o.dist != 0) {
                return this.dist - o.dist;
            }

            if(this.x - o.x != 0) {
                return this.x - o.x;
            }

            return this.y - o.y;
        }
    }

    static int time = 0;
    static int n;
    static int[][] map;
    static Node babyShark;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 9) {
                    babyShark = new Node(i, j, 2, 0);
                }
            }
        }

        int eatCount = 0;
        while(true) {
            PriorityQueue<Node> targetFishes = bfs(); // 먹을 수 있는 물고기들을 우선순위큐에 저장

            if(targetFishes.size() == 0) { // 더 이상 먹을 수 있는 물고기들이 없다.
                break;
            }

            Node targetFish = targetFishes.poll(); // 먹을 물고기
            map[targetFish.x][targetFish.y] = 9; // 먹음
            map[babyShark.x][babyShark.y] = 0; // 먹고 이동
            eatCount++; // 먹은 개수
            babyShark.x = targetFish.x; // 아기상어의 위치 이동
            babyShark.y = targetFish.y; // 아기성어의 위치 이동
            time += targetFish.dist; // 물고기를 먹는 데까지 걸린 시간

            if(eatCount == babyShark.size) { // 물고기를 자신 크기만큼 먹었으면 크기가 커진다.
                babyShark.size++;
                eatCount = 0; // 먹은 개수 초기화
            }
        }

        System.out.println(time);
    }

    public static PriorityQueue<Node> bfs() {
        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Node> targetFishes = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];

        q.add(new Node(babyShark.x, babyShark.y, 0, 0)); // 탐색을 시작하기 위해 아기상어의 위치를 큐에 넣는다.
        visited[babyShark.x][babyShark.y] = true; // 시작 위치에 방문 표시

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                /* 맵을 벗어나지 않고, 방문하지 않았으며, 만약 물고기가 있다면 그 물고기가 아기상어보다 '작거나 같은' 크기일 때 이동할 수 있다. */
                if(nx > -1 && ny > -1 && nx < n && ny < n && !visited[nx][ny] && babyShark.size >= map[nx][ny]) {
                    q.add(new Node(nx, ny, 0, cur.dist + 1));
                    if(map[nx][ny] != 0 && map[nx][ny] < babyShark.size) { // 해당 칸이 물고기고 아기상어보다 사이즈가 '작다면' 먹을 수 있다.
                        targetFishes.add(new Node(nx, ny, map[nx][ny], cur.dist+1));
                    }
                    visited[nx][ny] = true; // 방문 표시
                }
            }
        }

        return targetFishes;
    }
}