import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 스티커 */
public class algorithm_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            for(int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 1; j < n + 1; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }        
            }

            /* dp배열 초기화 */
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            /* 배열을 탐색하며 3가지 경우를 고려한다 */
            for(int i = 2; i < n + 1; i++) {
                for(int j = 0; j < 2; j++) {

                    int index = j == 0 ? 1 : 0; // j가 0이면 1, j가 1이면 0

                    int case1 = dp[index][i - 1] + arr[j][i];
                    int case2 = dp[0][i - 2] + arr[j][i];
                    int case3 = dp[1][i - 2] + arr[j][i];

                    dp[j][i] = Math.max(Math.max(case1, case2), case3);
                }        
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));

        }
    }
}
