import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] sum = new int[n + 1];
        int count = 0;
        st = new StringTokenizer(br.readLine());

        // 누적합 계산
        sum[1] = Integer.parseInt(st.nextToken());
        for(int i = 2; i < n + 1; i++) {
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
        }

        int start = 0;
        int end = 0;
        while(start < n) {
            if(end > n) {
                break;
            }

            int value = sum[end] - sum[start];

            if(value >= m) {
                start++;
            }
            if(value < m) {
                end++;
            }

            if(value == m) {
                count++;
            }
        }

        System.out.println(count);
    }
}
