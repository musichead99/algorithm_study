package algorithm_study.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];

        for(int i = 0; i < N; i++) {
            if(i == 0 || i == 1) dp[i] = 1;
            else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        System.out.println(dp[N-1]);
    }
}
