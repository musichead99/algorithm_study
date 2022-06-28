package algorithm_study.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이진탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int index = b_search(arr, target, 0, n-1) + 1;

        System.out.println("index : " + index + " value : " + arr[index-1]);

    }

    private static int b_search(int[] arr, int value, int start, int end) {

        if(start > end) return -1;
        int mid = (start + end) / 2;

        if(arr[mid] == value) {
            return mid;
        } else if (arr[mid] > value) {
            return b_search(arr, value, start, mid-1);
        } else {
            return b_search(arr, value, mid+1, end);
        }
    }
}
