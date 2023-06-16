import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class algorithm_11497 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] woods = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n ; i++) {
                int value = Integer.parseInt(st.nextToken());
                pq.offer(value);
            }

            woods[n / 2] = pq.poll();
            int rightIndex = n / 2 + 1;
            int leftIndex = n / 2 - 1;
            while(!pq.isEmpty()) {
                if(rightIndex < n) {
                    woods[rightIndex++] = pq.poll();
                }
                if(leftIndex >= 0) {
                    woods[leftIndex--] = pq.poll();
                }
            }

            int maxDiff = Math.abs(woods[0] - woods[n -1]);
            for(int i = 1; i < n; i++) {
                int diff = Math.abs(woods[i] - woods[i - 1]);

                maxDiff = Math.max(diff, maxDiff);
            }
            sb.append(maxDiff + "\n");
        }
        
        System.out.println(sb);
    }
}
