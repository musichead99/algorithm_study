import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algorithm_12026 {

    private static char[] map;
    private static int[] dp;
    private static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n + 1];
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[1] = 0;

        String temp = br.readLine();
        for(int i = 1; i < n + 1; i++) {
            map[i] = temp.charAt(i - 1);
        }

        for(int i = 1; i < n + 1; i++) {
            char now = map[i];

            switch(now) {
                case 'B':
                    update(i, 'O');
                    break;
                case 'O':
                    update(i, 'J');
                    break;
                case 'J':
                    update(i, 'B');
                    break;
            }
        }

        System.out.println(dp[n]);
    }

    private static void update(int index, char target) {
        if(dp[index] == -1) { // 이 위치에 도달한 적 없음
            return;
        }

        for(int i = index + 1; i < n + 1; i++) {
            if(map[i] == target) {
                int k = i - index;

                if(dp[i] == -1) {
                    dp[i] = k*k + dp[index];
                } else {
                    dp[i] = Math.min(k*k + dp[index], dp[i]);
                }
            }
        }
    }
}
