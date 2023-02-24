package algorithm_study.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드_정렬하기 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq =  new PriorityQueue<>(); // 우선순위 큐 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        /* 각 카드 묶음의 수를 우선순위 큐에 넣음 */
        for(int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        /* 우선순위 큐에서 가장 작은 두 개의 카드 묶음의 수를 꺼내서 더하고 다시 넣는것을 반복 */
        int result = 0;
        while(pq.size() != 1) {
            int a = pq.poll();
            int b = pq.poll();
            result += a + b;
            pq.offer(a + b);
        }

        System.out.println(result);

    }
}
