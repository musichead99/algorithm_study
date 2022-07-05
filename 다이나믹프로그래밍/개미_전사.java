package algorithm_study.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개미_전사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] storage = new int[N];

        br.close();

        for(int i = 0; i < N; i++) {
            storage[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N];

        dp[0] = storage[0];
        dp[1] = storage[1];

        for(int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + storage[i]);
        }

        System.out.println(dp[N-1]);
    }
}
