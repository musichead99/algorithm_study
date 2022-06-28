package algorithm_study.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡볶이_떡_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dduck = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            dduck[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dduck);

        System.out.println(b_search(dduck, M, 0, dduck[N-1]));

    }

    private static int b_search(int[] arr, int target, int start, int end) {
        if(start > end) return -1;
        int mid = (start + end) / 2;

        int sum = 0;
        for(int dduck : arr) {
            if(dduck - mid < 0) continue;
            sum += (dduck - mid);
        }

        if(target == sum) {
            return mid;
        } else if(target < sum) {
            return b_search(arr, target, mid + 1, end);
        } else {
            return b_search(arr, target, start, mid - 1);
        }
    }
}
