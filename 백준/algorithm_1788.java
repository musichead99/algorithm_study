import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_1788 {

    private static long[] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int absValue = Math.abs(n);

        dp = new long[absValue + 1];
        dp[0] = 0;

        if(n != 0) {
            dp[1] = 1;
        }

        if(n < 0) {
            negativeFibonacci(absValue);
        } else {
            fibonacci(absValue);
        }

        if(dp[absValue] < 0) {
            System.out.println(-1);
        } 
        if(dp[absValue] == 0) {
            System.out.println(0);
        }
        if(dp[absValue] > 0) {
            System.out.println(1);
        }
        
        System.out.println(Math.abs(dp[absValue]));

    }

    public static void fibonacci(int n) {
        for(int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] % 1000000000;
        }
    }

    public static void negativeFibonacci(int n) {
        for(int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 2] - dp[i - 1] % 1000000000;
        }
    }
}
