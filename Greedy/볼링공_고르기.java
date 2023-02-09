package algorithm_study.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 볼링공_고르기 {
    public static void main(String[] args) throws IOException {
        /* 입력값 받기 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] balls = new int[n];

        for(int i = 0; i < n; i++) {
            balls[i] = Integer.parseInt(st.nextToken());
        }

        /* 조합 구하기 */
        int count = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(balls[i] != balls[j]) count++;
            }
        }

        System.out.println(count);
    }
}