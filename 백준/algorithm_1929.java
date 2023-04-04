package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 에라토스테네스의 체를 사용 */
public class algorithm_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[n + 1];

        arr[0] = true; // 0은 소수 아님
        arr[1] = true; // 1은 소수 아님

        for(int i = 2; i <= Math.sqrt(n + 1); i++) {
            if(arr[i]) continue; // 만약 특정한 수의 배수였다면 건너 뜀
            for(int j = i * i; j < n + 1; j += i) { // 해당 수의 배수들은 소수가 아니므로 전부 false처리
                arr[j] = true;
            }
        }

        for(int i = m; i < n + 1; i++) {
            if(!arr[i]) System.out.println(i);
        }
    }
}
