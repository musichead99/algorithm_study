package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_24416 {

    static int countDp = 0;
    static int countRec = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dpFibonacci(N);
        dpRecursive(N);

        System.out.println(countRec + " " + countDp);
    }

    private static int dpFibonacci(int N) {
        int[] dp = new int[N];
        dp[0] = 1;
        dp[1] = 1;

        int i;
        for(i = 2; i < N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            countDp++;
        }
        return dp[N-1];
    }

    private static int dpRecursive(int N) {
        if(N == 1 || N == 2) {
            countRec++;
            return 1;
        }

        return dpRecursive(N - 1) + dpRecursive(N - 2);
    }
}