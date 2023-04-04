package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Wire implements Comparable<Wire> {
    int start;
    int end;

    public Wire(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Wire o) {
        return this.start - o.start;
    }
}

/* 전깃줄의 시작과 끝점 모두를 기준으로 '가장 긴 증가하는 수열'을 구한다. */
public class algorithm_2565 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Wire[] wires = new Wire[n];
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            wires[i] = new Wire(start, end);
        }

        /* 어느 한 전봇대를 기준으로 정렬해야 한다. */
        Arrays.sort(wires);

        int max = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(wires[i].start > wires[j].start && wires[i].end > wires[j].end) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } 
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(n - max);
    }
}
