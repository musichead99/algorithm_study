package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 럭키_스트레이트 {
    public static void main(String[] args) throws IOException {
        /* 점수 입력받기 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String score = br.readLine();

        /* 점수를 반으로 나누어 앞부분과 뒷부분을 변수에 대입 */
        String first = score.substring(0, score.length()/2);
        String second = score.substring(score.length()/2);

        /* 앞부분과 뒷부분의 각 자릿수의 합을 계산 */
        String LuckyStraight = "READY";
        int sumFirst = 0;
        int sumSecond = 0;
        for(int i = 0; i < first.length(); i++) {
            sumFirst += Character.getNumericValue(first.charAt(i));
            sumSecond += Character.getNumericValue(second.charAt(i));
        }

        /* 만약 럭키 스트레이트를 사용할 수 있다면(두 합이 같다면) "LUCKY"로 변경 */
        if(sumFirst == sumSecond) {
            LuckyStraight = "LUCKY";
        }

        System.out.println(LuckyStraight);
        br.close();
    }
}
