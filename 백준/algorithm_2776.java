import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class algorithm_2776 {

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static int[][] map;
    private static boolean[][] visited;
    private static int n;
    private static int complexCount;
    private static ArrayList<Integer> houses = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String temp = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        houses.sort(null);

        System.out.println(complexCount);

        for(int house : houses) {
            System.out.println(house);
        }
    }  

    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        int count = 1;
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >= n || ny >= n || nx < 0 || ny < 0) {
                    continue;
                }

                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }

        houses.add(count);
        complexCount++;
    }
}