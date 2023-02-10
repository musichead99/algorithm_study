package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class practice4_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* 하루 24시간의 모든 시각의 경우의 수는 24*60*60 = 86400가지이므로 브루트 포스를 통해 계산해도 시간이 초과되지 않음 */
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 60; j++) {
                for(int k = 0; k < 60; k++) {
                    if((Integer.toString(i) + Integer.toString(j) + Integer.toString(k)).contains("3")) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}
