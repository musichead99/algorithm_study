package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algorithm_11053 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1);

        st = new StringTokenizer(br.readLine());
        br.close();

        for(int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j < i; j++) {
                if(A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
