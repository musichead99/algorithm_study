package algorithm_study.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 만들_수_없는_금액 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        /* 입력값 n, coins 받기 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] coins = new int[n];
        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        /* 내가 푼 방법(시간초과 나올것임) */
        // int num = 1;
        // while(true) {
        //     int tmp = num;
        //     for(int coin : coins) {
        //         if(tmp - coin >= 0) {
        //             tmp -= coin;
        //             if(tmp == 0) break;
        //         }
        //     }
        //     if(tmp != 0) {
        //         break;
        //     }
        //     num++;
        // }

        /* 책에 나와있는 방법 */
        Arrays.sort(coins);

        int num = 1;
        for(int coin : coins) {
            if(coin > num) {
                break;
            }
            num += coin;
        }

        System.out.println(num);
    }
}
