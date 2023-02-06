package algorithm_study.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public interface 큰_수의_법칙_개선 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /* n(배열의 길이), m(숫자가 더해지는 횟수), k(특정한 인덱스의 수가 연속해서 더해질 수 있는 횟수) 파싱 */
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        /* 배열 입력받기 */
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /* 큰 수 2개를 찾기 위해 정렬 */
        Arrays.sort(arr);

        int first = arr[n-1];
        int second = arr[n-2];

        /* 더하기 시작 */
        int count = (m / (k + 1)) * k;
        count += m % (k + 1);

        int result = 0; 
        result += first * count; // 첫 번째로 큰 수가 더해진 값
        result += second * (m - count); // 두 번째로 큰 수가 더해진 값

        /* 출력 */
        System.out.println(result);
    }
}
