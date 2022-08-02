package algorithm_study.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 금광 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] answers = new int[T];

        for(int answer : answers) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] map = new int[n + 2][m + 1];
            int[][] dp = new int[n + 2][m + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            /* 왼쪽 위, 왼쪽 옆, 왼쪽 아래의 3가지 방향에서 오는 경우를 고려한다. */
            for(int j = 1; j <= m; j++) {
                for(int i = 1; i <= n; i++) {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1], dp[i][j - 1]), dp[i + 1][j - 1]) + map[i][j];
                }
            }

            answer = Math.max(Math.max(dp[n][m], dp[n - 1][m]), dp[n + 1][m]);
            sb.append(answer + "\n");
        }

        br.close();

        System.out.print(sb.toString());
    }
}
