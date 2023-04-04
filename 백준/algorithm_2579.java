package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 계단 오르기 */
public class algorithm_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        dp[1] = stairs[1];

        /* n = 1일 경우를 대비한 초기화 */
        if(n >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        /* 두 칸 전에서 올라오던가, 두칸 -> 한칸 통해서 올라오던가 */
        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(dp[n]);
    }
}
