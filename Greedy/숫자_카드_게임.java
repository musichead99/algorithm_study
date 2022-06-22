package algorithm_study.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자_카드_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /* N, M 입력 */
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /* 카드 입력 */
        int result = 0;
        int card[][] = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int min_value = 10001;
            for(int j = 0; j < M; j++) {
                card[i][j] = Integer.parseInt(st.nextToken());
                min_value = Math.min(min_value, card[i][j]);
            }
            result = Math.max(min_value, result);
        }
        System.out.println(result);

        /* 내가 작성했던 코드 */
    //     /* 카드 입력 */
    //     int card[][] = new int[N][M];
    //     for(int i = 0; i < N; i++) {
    //         st = new StringTokenizer(br.readLine());
    //         for(int j = 0; j < M; j++) {
    //             card[i][j] = Integer.parseInt(st.nextToken());
    //         }
    //     }

    //     /* 행마다 최소값 구하기 */
    //     int min[] = {10001, 10001, 10001};
        
    //     for(int i = 0; i < N; i++) {
    //         for(int j = 0; j < M; j++) {
    //             min[i] = min[i] < card[i][j] ? min[i] : card[i][j];
    //         }
    //     }

    //     /* 그 중 가장 큰 값 찾기 */
    //     int result = 0;
    //     for(int i = 0; i < N; i++) {
    //         result = result > min[i] ? result : min[i];
    //     }
    //     System.out.println(result);
    }
}
