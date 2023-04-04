package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algorithm_11724 {

    static ArrayList<ArrayList<Integer>> map;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            map.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.get(start).add(end);
            map.get(end).add(start);
        }

        visited = new boolean[n + 1];
        for(int i = 1; i < n + 1; i++) {
            bfs(i);
        }

        System.out.println(count);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        if(!visited[start]) {
            q.add(start);
        } else {
            return;
        }

        while(!q.isEmpty()) {
            int tmp = q.poll();

            for(int node : map.get(tmp)) {
                if(!visited[node]) {
                    q.add(node);
                    visited[node] = true;
                }
            }
        }
        count++;
    }   
}