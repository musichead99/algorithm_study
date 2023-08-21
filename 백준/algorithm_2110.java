import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algorithm_2110 {

    private static int n;
    private static int c;
    private static int[] arr;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        binarySearch(1, arr[n - 1] - arr[0]);

        System.out.println(result);
    }

    private static void binarySearch(int start, int end) {
        if(start > end) {
            return;
        }

        int mid = (start + end) / 2;
        int count = 1;
        int tmp = 0;

        for(int i = 1; i < n; i++) {
            if(arr[i] - arr[tmp] >= mid) {
                count++;
                tmp = i;
            }
        }

        if(count >= c) {
            result = Math.max(result, mid);
            binarySearch(mid + 1, end);
        } else if(count < c) {
            binarySearch(start, mid - 1);
        } 
    }
}
