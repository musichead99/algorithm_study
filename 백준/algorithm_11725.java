import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 트리의 부모 노드 */
public class algorithm_11725 {

    private static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    private static int[] result;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = new int[n + 1];

        for(int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            tree.get(start).add(end);
            tree.get(end).add(start);
        }

        bfs(1);

        for(int i = 2; i < n + 1; i++) {
            System.out.println(result[i]);
        }

    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int node : tree.get(cur)) {
                if(!visited[node]) {
                    q.add(node);
                    visited[node] = true;
                    result[node] = cur;
                }
            }
        }
    } 
}
