package algorithm_study.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 효율적인_화폐_구성 {
    static final int MAX_VALUE = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] coinTypes = new int[N];
        for(int i = 0; i < N; i++) {
            coinTypes[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[M + 1];
        Arrays.fill(dp, MAX_VALUE);

        /* 다이나믹프로그래밍 시작 */
        dp[0] = 0;
        for(int coin : coinTypes) {
            for(int i = coin; i < M + 1; i++) {
                if(dp[i - coin] != MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coin] + 1, i / coin);
                }
            }
        }
            if(dp[M] != 10001) System.out.println(dp[M]);
            else System.out.println(-1);
    }
}
