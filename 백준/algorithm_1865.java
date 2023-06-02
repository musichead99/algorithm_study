import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 웜홀(플로이드-워셜 방식) */
public class algorithm_1865 {

    static int INF = 250000000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int[][] map = new int[n + 1][n + 1];

            for(int i = 1; i < n + 1; i++) { // 그래프 초기화
                Arrays.fill(map[i], INF);
            }

            for(int i = 1; i < m + 1; i++) { // 도로
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                map[s][e] = Math.min(map[s][e], t);
                map[e][s] = Math.min(map[s][e], t);
            }
            
            for(int i = 1; i < w + 1; i++) { // 웜홀
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                map[s][e] = Math.min(map[s][e], -t);
            }

            String result = "NO";
            for(int k = 1; k < n + 1; k++) Loop: { // 플로이드
                for(int i = 1; i < n + 1; i++) {
                    for(int j = 1; j < n + 1; j++) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                    if(map[i][i] < 0) {
                        result = "YES";
                        break Loop;
                    }
                }
            }

            System.out.println(result);
        }
    }
}
