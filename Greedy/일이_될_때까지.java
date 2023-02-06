package algorithm_study.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일이_될_때까지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /* n, k 파싱 */
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0;
        
        /* 내가 풀어 본 예시(그대로 구현) */
        while(n != 1) {
            if(n % k == 0) {
                n /= k;
                count++;
            } else {
                n--;
                count++;
            }
        }

        System.out.println(count);
    }
}
