package algorithm_study.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 거스름돈 문제 */
public class practice3_1 {
    public static void main(String[] args) throws IOException {
        int count = 0;

        /* 사용자로부터 거슬러 줄 돈 N을 입력받는다. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* 계산대에 있는 동전들의 종류 */
        int[] coinType = {500,100,50,10};

        /* 큰 동전부터 순서대로 개수를 세어나간다. */
        for(int coin : coinType) {
            count += N / coin;
            N %= coin;
        }

        /* 출력 */
        System.out.println(count);
    }
}
