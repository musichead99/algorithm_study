package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue;

public class algorithm_1260 {
    
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        List<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        boolean[] visited = new boolean[N + 1];

        dfs(graph, V, visited);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(graph, V, visited);

        System.out.print(sb);
    }

    private static void dfs(List<ArrayList<Integer>> graph, int V, boolean[] visited) {
        visited[V] = true;
        sb.append(V + " ");

        for(int node : graph.get(V)) {
            if(!visited[node]) {
                dfs(graph, node, visited);
            }
        }
    }

    private static void bfs(List<ArrayList<Integer>> graph, int V, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            sb.append(temp + " ");

            for(int node : graph.get(temp)) {
                if(!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }
}
