import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];
        dp[0] = 1;
        
        if(n != 0) {
            dp[1] = 1;
        }

        for(int i = 2; i < n+1; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i - j - 1];
            }
        }

        System.out.println(dp[n]);
    }
}
