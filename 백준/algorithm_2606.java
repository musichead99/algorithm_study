package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algorithm_2606 {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start); // 양방향 그래프이다.
        }
        boolean[] visited = new boolean[v + 1];

        bfs(graph, visited);

        System.out.println(count);
    }

    public static void bfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int tmp = q.poll();

            for(int node : graph.get(tmp)) {
                if(!visited[node]) {
                    q.add(node);
                    visited[node] = true;
                    count++;
                }
            }
        }
    }
}
