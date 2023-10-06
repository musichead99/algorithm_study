import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class algorithm_1744 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = 0; i < n; i++) {
            if(arr[i] < 1) {
                minPQ.add(arr[i]);
            } else {
                maxPQ.add(arr[i]);
            }
        }

        int sum = 0;
        while(maxPQ.size() > 1) {
            int num1 = maxPQ.poll();
            int num2 = maxPQ.poll();

            if(num1 == 1 || num2 == 1) {
                sum += num1 + num2;
                continue;
            }

            sum += num1 * num2;
        }

        if(!maxPQ.isEmpty()) {
            sum += maxPQ.poll();
        }

        while(minPQ.size() > 1) {
            sum += minPQ.poll() * minPQ.poll();
        }
        
        if(!minPQ.isEmpty()) {
            sum += minPQ.poll();
        }

        System.out.println(sum);
    }
}
