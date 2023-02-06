package algorithm_study.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱하기_혹은_더하기 {
    public static void main(String[] args) throws IOException {

        /* 문자열 s 파싱 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        /* 곱하기 혹은 더하기 수행 */
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            int tmp = Character.getNumericValue(s.charAt(i));

            /* 만약 여태까지 구한 값(result)이나 현재 계산할 값(tmp)이 1보다 작거나 같다면 더하는 게 이득이다. */
            if(tmp <= 1 || result <= 1) {
                result += tmp;
            } else {
                result *= tmp;
            }
        }

        System.out.println(result);
    }
}
