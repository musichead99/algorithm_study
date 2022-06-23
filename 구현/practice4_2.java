package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 0시부터 N시까지 3이 하나라도 포함된 시각의 수를 계산 */
public class practice4_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* 브루트 포스로 계산한다. */
        int count = 0;
        for(int i = 0; i < N + 1; i++) {
            for(int j = 0; j < 60; j++) {
                for(int k = 0; k < 60; k++) {
                    if((Integer.toString(i) + Integer.toString(j) + Integer.toString(k)).contains("3")) count++;
                }
            }
        }
        System.out.println(count);
    }
}
