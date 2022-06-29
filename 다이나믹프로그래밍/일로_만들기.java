package algorithm_study.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로_만들기 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[30001];
        dp[0] = N;

        int i = 1;
        for(; i < 30001; i++) {
            dp[i] = dp[i-1]-1;

            if(dp[i] % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i]/2 + 1);
            } else if(dp[i] % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i]/3 + 1);
            } else if(dp[i] % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i]/8 + 1);
            }

            if(dp[i] == 1) {
                break;
            }
        }
        System.out.println(i);
    }
}
