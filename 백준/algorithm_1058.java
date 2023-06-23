import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class algorithm_1058 {

    private static class Node {
        int index;
        int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    private static char[][] people;
    private static boolean[] visited;
    private static int n;
    private static int maxCount = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        people = new char[n][n];

        for(int i = 0; i < n; i++) {
            String temp = br.readLine();
            for(int j = 0; j < n; j++) {
                people[i][j] = temp.charAt(j);
            }
        }

        for(int i = 0; i < n; i++) {
            bfs(i);
        }

        System.out.println(maxCount);

    }

    private static void bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        int count = 0;
        visited = new boolean[n];
        q.offer(new Node(start, 0));
        visited[start] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i = 0; i < n; i++) {
                char node = people[cur.index][i];

                if(node == 'Y' && !visited[i] && cur.count < 2) {
                    q.offer(new Node(i, cur.count + 1));
                    visited[i] = true;
                    count++;
                }
            }
        }

        maxCount = Math.max(count, maxCount);
    }
}
