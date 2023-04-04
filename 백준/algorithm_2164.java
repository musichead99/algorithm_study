package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class algorithm_2164 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            q.add(i);
        }

        boolean pop = true; // 카드를 버릴지 뒤로 넣을지 결정하는 플래그
        while(q.size() != 1) { // 큐에 노드가 하나만 남을 때 까지 반복
            if(pop) { // 카드 버림
                q.poll();
                pop = !pop;
            } else { // 카드 뒤로 넣음
                int tmp = q.poll();
                q.add(tmp);
                pop = !pop;
            }
        }

        System.out.println(q.poll());
    }
}
