package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 문자열_재정렬 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        int sum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            char token = str.charAt(i);
            if(token >= 'A' && token <= 'Z') {
                pq.add(token);
            } else {
                sum += Character.getNumericValue(token);
            }
        }

        while(!pq.isEmpty()) {
            System.out.print(pq.poll());
        }
        System.out.println(sum);
    }
}
