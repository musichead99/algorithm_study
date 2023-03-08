package algorithm_study.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 금광 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            /* 금광에 금 정보 입력하기 */
            int[][] map = new int[n + 2][m + 1];
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n + 1; j++) {
                for(int k = 1; k < m + 1; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            /* 현 시점에서 얻을 수 있는 금의 최대 크기 = 해당 지점의 왼쪽 위, 왼쪽, 왼쪽 아래 중 얻을 수 있는 가장 큰 금의 크기 + 현재 금의 크기 */
            int[][] dp = new int[n + 2][m + 1];
            for(int k = 1; k < m + 1; k++) {
                for(int j = 1; j < n + 1; j++) {
                    dp[j][k] = Math.max(Math.max(dp[j - 1][k - 1], dp[j][k - 1]), dp[j + 1][k - 1]) + map[j][k];
                }
            }

            int result = Math.max(Math.max(dp[n][m], dp[n - 1][m]), dp[n - 2][m]);
            System.out.println(result);
        }
    }
}
