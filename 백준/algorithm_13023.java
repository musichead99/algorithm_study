import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class algorithm_13023 {

    private static int n;
    private static int m;

    private static final int TARGET_LENGTH = 5;

    private static ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            g.get(start).add(end);
            g.get(end).add(start);
        }

        for(int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, 1);
        }

        System.out.println(0);
    }

    private static void dfs(int start, int depth) {
        if(depth == TARGET_LENGTH) {
            System.out.println(1);
            System.exit(0);
        }

        for(int node : g.get(start)) {
            if(!visited[node]) {
                visited[node] = true;
                dfs(node, depth + 1);
                visited[node] = false;
            }
        }
    }
}
