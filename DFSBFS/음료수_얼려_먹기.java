package algorithm_study.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음료수_얼려_먹기 {
    private static int N;
    private static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        /* 얼음판 정보 입력받기 */
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        br.close();

        /* dfs를 이용해 해당 좌표에 대해 연결된 모든 곳을 탐색 후 count 개수 증가 */
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(dfs(map, i, j)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static boolean dfs(int[][] graph, int i, int j) {
        
        /* 파라미터로 받은 좌표가 얼음판의 크기를 넘어가는지 체크 */
        if(i < 0 || j < 0 || i >= N || j >= M) {
            return false;
        }
        
        /* 해당 노드가 방문하지 않았던 노드일 경우 상하좌우 dfs 탐색 */
        if(graph[i][j] == 0) {
            graph[i][j] = 1;
            dfs(graph, i + 1, j);
            dfs(graph, i - 1, j);
            dfs(graph, i, j + 1);
            dfs(graph, i, j - 1);
            return true;
        }

        return false;
    }
}
