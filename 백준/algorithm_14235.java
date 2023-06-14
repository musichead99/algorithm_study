import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class algorithm_14235 {

    private static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());

            if(value == 0) {
                givePresent();
            }

            if(value != 0) {
                takePresent(st);
            }
        }

        System.out.println(sb);
    }

    public static void givePresent() {
        if(pq.isEmpty()) {
            sb.append(-1 + "\n");
            return;
        }

        sb.append(pq.poll() + "\n");
    }

    public static void takePresent(StringTokenizer st) {
        while(st.hasMoreTokens()) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
    }
}
