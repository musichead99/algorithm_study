package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class algorithm_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            Integer x = Integer.parseInt(br.readLine());

            if(x > 0) {
                pq.add(x);
            } else {
                if(!pq.isEmpty()) {
                    sb.append(pq.poll() + "\n");
                } else {
                    sb.append(x + "\n");
                }
            }
        }

        System.out.println(sb);
    }
}
