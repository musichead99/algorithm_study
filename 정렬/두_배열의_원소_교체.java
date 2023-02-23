package algorithm_study.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 두_배열의_원소_교체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] A = new Integer[n];
        Integer[] B = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for(int i = 0; i < k; i++) {
            if(A[i] < B[i]) {
                int tmp = A[i];
                A[i] = B[i];
                B[i] = tmp;
            }
        }

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += A[i];
        }

        System.out.println(sum);
    }
}
