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
        for(int i = 0; i < s.length() - 1; i++) {

            /* 현재 숫자가 다음의 숫자와 다를 경우 */
            if(s.charAt(i) != s.charAt(i + 1)) {
                /* 현재 숫자 까지의 숫자 집합을 카운트한다 */
                if(s.charAt(i) == '0') {
                    count[0]++;
                } else {
                    count[1]++;
                }
            }
        }

        /* 문자열 맨 뒤의 숫자 집합 포함시키기 */
        if(s.charAt(s.length() - 1) == '0') {
            count[0]++;
        } else {
            count[1]++;
        }

        /* 더 적게 뒤집어도 되는 경우를 출력한다 */
        System.out.println(Math.min(count[0], count[1]));
    }
}
