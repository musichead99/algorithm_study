package algorithm_study.DFSBFS;

import java.util.Arrays;

public class practice5_8 {
    public static void main(String[] args) {
        
        /* 인접 행렬을 통한 graph생성 */
        int[][] graph = {
            {},
            {2, 3, 8},
            {1, 7},
            {1, 4, 5},
            {3, 5},
            {3, 4},
            {7},
            {2, 6, 8}, 
            {1, 7}
        };

        /* visited 배열 선언 및 초기화 */
        boolean[] visited = new boolean[9];
        Arrays.fill(visited, false);

        int v = 1;

        dfs(graph, v, visited);

    }

    /* 재귀를 통한 dfs */
    private static void dfs(int[][] graph, int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for(int node : graph[v]) {
            if(!visited[node]) {
                dfs(graph, node, visited);
            }
        }
    }
}
