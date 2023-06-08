import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_2293 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int[] dp = new int[100001]; // 동전의 가치가 k보다 클 수 있음

        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int coin : coins) {
            dp[coin] += 1;

            for(int i = coin + 1; i < k + 1; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }

        System.out.println(dp[k]);
    }
}