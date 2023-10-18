import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i = 1; i < n + 1; i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= n - k; i++) {
            int tmp = arr[i + k] -arr[i];

            max = Math.max(tmp, max);
        }

        System.out.println(max);
    }
}