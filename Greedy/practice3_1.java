package algorithm_study.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 거스름돈 문제 */
public class practice3_1 {

    public static int[] coins = {500, 100, 50, 10};

    public static void main(String[] args) throws IOException {
        int count = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        br.close();

        for(int coin : coins) {
            if(n >= coin) {
                count += n / coin;
                n = n % coin;
            }
        }

        System.out.println(count);
    }
}
