package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algorithm_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 이진탐색을 위한 정렬

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int value = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(0, n - 1, arr, value));
        }
    }

    public static int binarySearch(int start, int end, int[] arr, int target) {
        int mid = (start + end) / 2;

        if(start > end) return 0; // 끝까지 찾지 못했다면 0반환

        if(arr[mid] == target) return 1; // 찾았다면 1 반환
        else if(arr[mid] > target) return binarySearch(start, mid - 1, arr, target);
        else return binarySearch(mid + 1, end, arr, target);
    }
}
