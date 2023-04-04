package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            fibonacci(n);
        }
    }

    public static void fibonacci(int n) {
        int[][] dp = new int[2][n + 2]; // n = 0일 때의 ArrayIndexOutOFBoundException을 방지하기 위해 메모리 공간을 조금 더 사용
        dp[0][0] = 1;
        dp[1][1] = 1;

        for(int i = 2; i < n + 1; i++) {
            dp[0][i] = dp[0][i - 2] + dp[0][i - 1];
            dp[1][i] = dp[1][i - 2] + dp[1][i - 1];
        }

        System.out.println(dp[0][n] + " " + dp[1][n]);
    } 
}
