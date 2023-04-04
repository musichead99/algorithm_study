package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /* 일반적인 소수 구하기 */
        int count = 0;
        for(int i = 0; i < n; i++) {
            int flag = 0;
            for(int j = 1; j <= arr[i]; j++) {
                if(arr[i] % j == 0) {
                    flag++;
                }
            }

            if(flag == 2) {
                count++;
            }
        }

        System.out.println(count);
    }
}
