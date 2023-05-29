import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algorithm_11404 {

    static int INF = 1000000000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 정점
        int m = Integer.parseInt(br.readLine()); // 간선
        int[][] map = new int[n + 1][n + 1];

        for(int i = 0; i < n + 1; i++) {
            Arrays.fill(map[i], INF);
        }

        for(int i = 1; i < n + 1; i++) {
            map[i][i] = 0;
        } 
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.
            map[start][end] = Math.min(map[start][end], cost); 
        }

        for(int k = 1; k < n + 1; k++) {
            for(int i = 1; i < n + 1; i++) {
                for(int j = 1; j < n + 1; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(map[i][j] == INF) { // 갱신되지 못했을경우 i에서 j로 갈 수 없다는 뜻이므로 0으로 갱신
                    map[i][j] = 0;
                }

                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
