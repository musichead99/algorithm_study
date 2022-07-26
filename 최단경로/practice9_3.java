package algorithm_study.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class practice9_3 {
    static int INF = (int)1e9;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드의 개수
        int M = Integer.parseInt(br.readLine()); // 간선의 개수

        /* 그래프 생성 후 전체 무한값으로 초기화 */
        int[][] graph = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], INF);
        }

        /* 자기 자신으로 가는 경로는 없으므로 0으로 초기화 */
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <=N; j++) {
                if(i == j) graph[i][j] = 0;
            }
        }

        /* 간선의 시작점, 끝점, 비용을 입력받아 그래프에 적용 */
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph[start][end] = value;
        }

        /* 플로이드 워셜 알고리즘 */
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                for(int k = 1; k <= N; k++) {
                    if(j != i && k != i) {
                        graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                    } 
                }
            }
        }
        
        System.out.println(Arrays.deepToString(graph));
    }
}