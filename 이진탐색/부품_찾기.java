package algorithm_study.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부품_찾기 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int M = Integer.parseInt(br.readLine());
        int[] list = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        for(int part : list) {
            if(b_search(arr, part, 0, arr.length)) {
                sb.append("yes ");
            } else {
                sb.append("no ");
            }
        }
        System.out.println(sb);
    }

    private static boolean b_search(int[] arr, int target, int start, int end) {
        if(start > end) return false;
        int mid = (start + end) / 2;

        if(arr[mid] == target) {
            return true;
        } else if(arr[mid] > target) {
            return b_search(arr, target, start, mid - 1);
        } else {
            return b_search(arr, target, mid + 1, end);
        }
    }
}
