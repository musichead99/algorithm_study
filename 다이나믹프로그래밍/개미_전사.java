package algorithm_study.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개미_전사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] storage = new int[n];

        br.close();

        for(int i = 0; i < n; i++) {
            storage[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n];

        dp[0] = 1;
        dp[1] = 3;

        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + storage[i], dp[i - 1]);
        }

        System.out.println(dp[n - 1]);
    }
}
