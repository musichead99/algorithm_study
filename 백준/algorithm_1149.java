import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_1149 {

    static final int RGB = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][RGB];
        int[][] map = new int[n + 1][RGB];
        for(int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < RGB; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < RGB; j++) {
                dp[i][j] = Math.min(map[i][j] + dp[i - 1][(j + 1) % RGB], map[i][j] + dp[i - 1][(j + 2) % RGB]);
            }
        }

        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}