package algorithm_study.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* N의 개수가 최대 100개이므로 O(n^3)의 연산을 수행해도 시간 제한을 넘기지 않는다. -> 플로이드 워셜 알고리즘 */
public class 미래_도시 {
    static int INF = (int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /* 그래프 초기화 */
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

        /* 간선 초기화 */
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        br.close();

        /* 플로이드 워셜 알고리즘 */
        for(int x = 1; x <= N; x++) {
            for(int y = 1; y <= N; y++) {
                for(int z = 1; z <= N; z++) {
                    graph[y][z] = Math.min(graph[y][z], graph[y][x] + graph[x][z]);
                }
            }
        }

        int d = graph[1][K] + graph[K][X];

        if(d >= INF) System.out.println(-1);
        else System.out.println(d);
    }
}
