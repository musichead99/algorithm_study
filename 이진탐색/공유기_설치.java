package algorithm_study.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기_설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] houses = new int[n];
        for(int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        int start = 1;
        int end = houses[n - 1] - houses[0];
        int result = 0;

        /* 이진 탐색 시작 */
        while(start <= end) {
            int mid = (start + end) / 2;

            int value = houses[0] + mid;
            int count = 1;
            /* 정해진 간격(mid)대로 순서대로 설치해 봄 */
            for(int i = 1; i < n; i++) {
                if(houses[i] >= value) { // 만약 설치 가능하다면 설치
                    count++;
                    value = houses[i] + mid;
                }
            }

            /* 해당 간격대로 설치했을 때 정해진 설치 수 보다 더 많이 설치할 수 있다면 간격을 넓힘 */
            if(count >= c) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
