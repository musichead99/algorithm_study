package algorithm_study.DFSBFS;

public class practice5_8 {
    public static void main(String[] args) {
        
        /* 인접 행렬로 그래프 표현 */
        int[][] graph = {
            {},
            {2,3,8},
            {1,7},
            {1,4,5},
            {3,5},
            {3,4},
            {7},
            {2,6,8},
            {1,7}
        };

        /* 방문한 노드인지를 체크하는 visited 배열 */
        boolean[] visited = new boolean[graph.length];

        /* dfs on */
        dfs(graph, 1, visited);
    }

    /* dfs탐색을 재귀함수로 구현 */
    public static void dfs(int[][] graph, int n, boolean[] visited) {
        visited[n] = true;
        System.out.print(n + " ");

        for(int node : graph[n]) {
            if(visited[node] == false) {
                dfs(graph, node, visited);
            }
        }
    }
}
