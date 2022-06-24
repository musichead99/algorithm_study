package algorithm_study.DFSBFS;

import java.util.Arrays;
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

        /* visited 배열 선언 및 초기화 */
        boolean[] visited = new boolean[9];
        Arrays.fill(visited, false);

        int v = 1;

        bfs(graph, v, visited);
    }

    /* bfs 함수 */
    private static void bfs(int[][] graph, int v, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        
        /* 시작 노드를 큐에 넣고 방문처리 */
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for(int i : graph[node]) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}
