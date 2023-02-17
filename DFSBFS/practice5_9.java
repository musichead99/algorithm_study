package algorithm_study.DFSBFS;

import java.util.LinkedList;
import java.util.Queue;

public class practice5_9 {
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

        bfs(graph, 1);

    }

    /* bfs 구현 */
    public static void bfs(int[][] graph, int n) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();

        q.add(n);
        visited[n] = true;

        while(!q.isEmpty()) {
            int tmp = q.poll();
            System.out.print(tmp + " ");

            for(int node : graph[tmp]) {
                if(visited[node] == false) {
                    q.add(node);
                    visited[node] = true;
                }
            }
        }
    }
}
