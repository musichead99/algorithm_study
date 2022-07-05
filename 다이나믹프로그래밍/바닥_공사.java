package algorithm_study.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 바닥_공사 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        br.close();

        int[] dp = new int[N];

        dp[0] = 1;
        dp[1] = 3;

        for(int i = 2; i < N; i++) {
            dp[i] = dp[i-1] + dp[i-2] * 2;
        }

        int result = dp[N-1] % 796796;
        System.out.println(result);
    }
}
