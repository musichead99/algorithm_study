package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        /* n = 1일때 조심 */
        int[] dp = new int[n + 2]; 
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i < n + 1; i++) {
            /* mod연산을 한 결과값을 출력해야 할 때는 반드시 연산할 때마다 mod연산을 해주어야 한다
             * 마지막에만 mod연산을 할 경우 overflow가 발생할 수 있기 때문!!
             */
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
