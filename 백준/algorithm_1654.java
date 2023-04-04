package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        int[] lanCable = new int[k];

        int big = 0;
        for(int i = 0; i < k; i++) {
            lanCable[i] = Integer.parseInt(br.readLine());
            big = Math.max(big, lanCable[i]);
        }

        System.out.println(binarySearch(1, big, lanCable, n));

    }

    /* int로 할 경우 start + end시 오버플로우가 발생할 수 있다. */
    public static long binarySearch(long start, long end, int[] lanCable, int n) {
        long mid = (start + end) / 2;

        if(end < start) return mid;

        int count = 0;
        for(int cable : lanCable) {
            count += (cable / mid);
        }

        if(count < n) {
            return binarySearch(start, mid - 1, lanCable, n);
        } else {
            return binarySearch(mid + 1, end, lanCable, n);
        }
    }
}
