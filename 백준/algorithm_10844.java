import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_10844 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];
        int sum = 0;
        
        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i < n + 1; i++) {
            for(int j = 0; j < 10; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                    continue;
                }

                if(j == 9) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }

                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }

        for(int i = 0; i < 10; i++) {
            sum = (dp[n][i] + sum) % 1000000000;
        }

        System.out.println(sum);
    }
}
