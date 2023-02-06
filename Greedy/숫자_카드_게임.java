package algorithm_study.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자_카드_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /* n, m 파싱 */
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        /* 카드 파싱 */
        int[][] cards = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                cards[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(cards[i]); // 각 행의 최소값들을 빠르게 찾기 위한 정렬
        }

        /* 각 행의 최소값 중 가장 큰 값 찾기 */
        int value = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            value = Math.max(value, cards[i][0]);
        }

        /* 출력 */
        System.out.println(value);

    }
}
