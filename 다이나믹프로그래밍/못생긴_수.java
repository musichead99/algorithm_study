package algorithm_study.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 못생긴_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int i2 = 1;
        int i3 = 1;
        int i5 = 1;

        int next2 = 2;
        int next3 = 3;
        int next5 = 5;

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = Math.min(Math.min(next2, next3), next5);

            if(dp[i] == next2) {
                i2++;
                next2 = dp[i2] * 2;
            }
            if(dp[i] == next3) {
                i3++;
                next3 = dp[i3] * 3;
            }
            if(dp[i] == next5) {
                i5++;
                next5 = dp[i5] * 5;
            }
        }

        System.out.println(dp[n]);
    }
}
