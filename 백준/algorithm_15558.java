import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algorithm_15558 {

    private static class Node {
        public int line;
        public int x;

        public Node(int line, int x) {
            this.line =line;
            this.x = x;
        }
    }

    private static int n;
    private static int k;
    private static int[][] line = new int[2][200002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(line[0], 1);
        Arrays.fill(line[1], 1);

        String str = br.readLine();
        for(int i = 1; i <= n; i++) {
            line[0][i] = Character.getNumericValue(str.charAt(i - 1));
        }

        str = br.readLine();
        for(int i = 1; i <= n; i++) {
            line[1][i] = Character.getNumericValue(str.charAt(i - 1));
        }

        bfs();

        System.out.println(0);
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[2][200002];
        int count = 1;
        q.add(new Node(0, 1));
        visited[0][1] = true;

        while(!q.isEmpty()) {
            int length = q.size();

            for(int i = 0; i < length; i++) {
                Node cur = q.poll();

                if(cur.x > n) {
                    System.out.println(1);
                    System.exit(0);
                }

                if(line[cur.line][cur.x + 1] != 0 && !visited[cur.line][cur.x + 1]) {
                    q.add(new Node(cur.line, cur.x + 1));
                    visited[cur.line][cur.x + 1] = true;
                }

                if(line[Math.abs(cur.line - 1)][cur.x + k] != 0 && !visited[Math.abs(cur.line - 1)][cur.x + k]) {
                    q.add(new Node(Math.abs(cur.line - 1), cur.x + k));
                    visited[Math.abs(cur.line - 1)][cur.x + k] = true;
                }

                if(line[cur.line][cur.x - 1] != 0 && cur.x - 1 > count && !visited[cur.line][cur.x - 1]) {
                    q.add(new Node(cur.line, cur.x - 1));
                    visited[cur.line][cur.x - 1] = true;
                }
            }

            count++;
        }
    }
}
