package algorithm_study.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두_배열의_원소_교체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] arr_A = new Integer[N];
        Integer[] arr_B = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr_A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr_B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr_A);
        Arrays.sort(arr_B, (v1, v2) -> v2 - v1);
        System.out.println(Arrays.toString(arr_A));
        System.out.println(Arrays.toString(arr_B));

        for(int i = 0; i < K; i++) {
            if(arr_A[i] < arr_B[i]) {
                arr_A[i] = arr_B[i];
            }
        }

        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += arr_A[i];
        }

        System.out.println(sum);
    }
}
