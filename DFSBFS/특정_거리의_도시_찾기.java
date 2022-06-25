package algorithm_study.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정_거리의_도시_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        /* 그래프 입력을 위한 인접 리스트 선언 */
        List<ArrayList<Integer>> map = new ArrayList<>();

        /* 리스트 초기화 */
        for(int i = 0; i <= N; i++) {
            map.add(new ArrayList<Integer>());
        }

        /* 입력받은 간선 정보를 인접리스트에 추가 */
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.get(start).add(end);
        }

        /* 방문 배열 생성 */
        int[] visited = new int[N + 1];
        Arrays.fill(visited, -1);
        
        bfs(map, X, visited);

        for(int i = 1; i <= N; i++) {
            if(visited[i] == K) sb.append(i + "\n");
        }

        if(sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.print(sb);
        }

    }

    private static void bfs(List<ArrayList<Integer>> graph, int start, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start]++;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            
            for(int i : graph.get(node)) {
                if(visited[i] == -1) {
                    visited[i] = visited[node] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
