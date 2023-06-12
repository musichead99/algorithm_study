import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_9009 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] dp = new int[45];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i < 45; i++) { // 10억 보다 작은 피보나치 수를 미리 구함
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for(int i = 44; i > -1; i--) { // 큰 피보나치 수부터 작아지는 방향으로 반복문
                if(n <= 0) { // n이 0이 되면 탈출
                    break;
                }

                if(n >= dp[i]) { // 피보나치 수가 n보다 작아지는 시점이 오면
                    sb.insert(0, dp[i] + " ");
                    n -= dp[i]; // n에서 그 값을 빼 준다.
                    continue;
                }
            }

            System.out.println(sb);
        }
    }
}
