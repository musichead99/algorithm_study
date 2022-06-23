package algorithm_study.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 큰_수의_법칙 {
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

        /* 내가 짠 코드 */
        // int maxIndex = N-1;
        // int sum = 0;

        // for(int i = 0; i < M; i++) {
        //     for(int j = 0; j < K && i < M; j++, i++) {
        //         sum += num[maxIndex];
        //     }
        //     sum += num[maxIndex-1];
        // }

        /* 첫 번째로 큰 수와, 두 번째로 큰 수만을 취하여 계산 -> 매번 배열에 인덱스 접근을 하지 않아도 됨 -> 성능증가, 가독성 증가 */
        int first = num[N-1];
        int second = num[N-2];
        int sum = 0;

        while(true) {
            for(int i = 0; i < K; i++) {
                if(M == 0) break;
                sum += first;
                M--;
            }
            if(M == 0) break;
            sum += second;
            M--;
        }

        System.out.println(sum);
        br.close();
    }
}
