package algorithm_study.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_뒤집기 {

    public static void main(String[] args) throws IOException {

        /* 문자열 s 입력받기 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        /* 연속된 문자 집합의 수 계산 */
        int[] count = new int[2];
        char binary = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {

            /* 현재 숫자가 이전의 숫자와 다를 경우 */
            if(s.charAt(i) != binary) {
                /* 현재 숫자 전까지의 숫자 집합을 카운트한다(현재 숫자가 0일경우 이전까지의 집합은 1의 집합) */
                if(s.charAt(i) == '0') {
                    count[1]++;
                } else if(s.charAt(i) == '1') {
                    count[0]++;
                }
                binary = s.charAt(i);
            }
        }

        /* 더 적게 뒤집어도 되는 경우를 출력한다 */
        System.out.println(Math.min(count[0], count[1]));
    }
}
