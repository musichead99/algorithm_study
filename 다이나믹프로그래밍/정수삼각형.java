package algorithm_study.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정수삼각형 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }
        
        Arrays.sort(dp[n]);
        System.out.println(dp[n][n]);
    }
}
