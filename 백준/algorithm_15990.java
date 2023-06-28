import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_15990 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[][] dp = new int[4][100001];
            
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[1][3] = 1;
        dp[2][3] = 1;
        dp[3][3] = 1;

        for(int i = 4; i < 100001; i++) {
            dp[1][i] = (dp[2][i - 1] + dp[3][i - 1]) % 1000000009;
            dp[2][i] = (dp[3][i - 2] + dp[1][i - 2]) % 1000000009;
            dp[3][i] = (dp[1][i - 3] + dp[2][i - 3]) % 1000000009;
        }

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int sum = 0;
            for(int i = 1; i < 4; i++) {
                sum = (sum + dp[i][n]) % 1000000009;
            }

            sb.append(sum +"\n");
        }

        System.out.println(sb);
    }
}
