import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algorithm_1707 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Integer>> g = new ArrayList<>();
            int[] visited = new int[v + 1];

            for(int i = 0; i < v + 1; i++) {
                g.add(new ArrayList<>());
            }

            for(int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                g.get(start).add(end);
                g.get(end).add(start);
            }

            String msg = "YES";
            for(int i = 1; i < v + 1; i++) {
                if(!bfs(g, visited, i)) {
                    msg = "NO";
                    break;
                }
            }
            sb.append(msg + "\n");
        }

        System.out.println(sb);
    }

    private static boolean bfs(ArrayList<ArrayList<Integer>> g, int[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        int group = 1;
        if(visited[start] == 0) {
            visited[start] = group;
        }
        q.add(start);

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int node : g.get(cur)) {
                if(visited[node] == 0) {
                    visited[node] = -visited[cur];
                    q.add(node);
                } else if(visited[cur] == visited[node]) {
                    return false;
                }
            }
        }

        return true;
    }
}