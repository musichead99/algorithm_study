import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_2688 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[][] dp = new long[10][n + 1]; // 오버플로우 방지
            for(int i = 0; i < 10; i++) {
                dp[i][1] = 1;
            }

            /* i자리 수에서 0~9로 끝나는 수의 개수를 각자 dp배열에 저장 */
            for(int i = 2; i < n + 1; i++) {
                for(int j = 0; j < 10; j++) {
                    for(int k = j; k < 10; k++) {
                        dp[j][i] += dp[k][i - 1];
                    }
                }
            }

            long sum = 0;
            for(int i = 0; i < 10; i++) {
                sum += dp[i][n];
            }

            System.out.println(sum);
        }
    }
}
