package algorithm_study.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 큰_수의_법칙_최적화 {
    public static void main(String[] args) throws IOException {
         /* N, M, K 파싱 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        /* N개의 자연수 입력받기 */
        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        /* 입력받은 수 정렬 */
        Arrays.sort(num);
        int first = num[N-1];
        int second = num[N-2];
        int sum = 0;

        /* first + first + first + second가 수열로서 반복되기 때문에 이런 식으로 더 간편하게 구할 수 있다. */
        int count = M / (K + 1) * K + M % (K + 1); // 전체 횟수 중 가장 큰 값(first)이 반복되는 횟수
        sum = count * first;
        sum += (M-count) * second;

        System.out.println(sum);
        br.close();
    }
}
