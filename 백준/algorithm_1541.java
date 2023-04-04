package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String str = br.readLine();

        /* 주어진 수식을 '-'마다 끊는다 */
        st = new StringTokenizer(str, "-");

        int result = 0; // 최종 결과값을 입력받을 변수
        int flag = 1; // 첫 번째 result 갱신임을 판단하기 위한 flag
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            int tokenLength = token.length();

            /* 각 수식들의 값을 계산해 sum에 저장 */
            int sum = 0;
            int count = 0;
            for(int i = 0; i < tokenLength; i++) {
                if(token.charAt(i) == '+') {
                    sum += Integer.parseInt(token.substring(i - count, i));
                    count = 0;
                }
                count++; // 수의 자릿수 계산
            }
            sum += Integer.parseInt(token.substring(tokenLength - count, tokenLength));

            /* result에 첫 갱신일 때는 더해주어야 함 */
            if(flag == 1) {
                result += sum;
                flag = 0;
            } else { // 이후의 연산은 -연산이므로 빼주어야 함
                result -= sum;
            }
        }

        System.out.println(result);

    }
}