import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algorithm_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][n + 1];
        int[][] sum = new int[n + 1][n + 1];

        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                /* 누적합 계산 */
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + map[i][j];
            }
        }

        System.out.println(Arrays.deepToString(sum));

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            /* 구간 사이의 합 계산 */
            System.out.println(sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1]);
        }
    }
}