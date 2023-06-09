import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_15624 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[0] = 0;

        if(n > 0) {
            dp[1] = 1;
        }

        for(int i = 2; i < n + 1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }

        System.out.println(dp[n]);
    }
}
