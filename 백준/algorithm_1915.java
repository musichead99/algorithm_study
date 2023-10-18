import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i < n + 1; i++) {
            String str = br.readLine();
            for(int j = 1; j < m + 1; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j - 1));
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(map[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max*max);
    }
}
