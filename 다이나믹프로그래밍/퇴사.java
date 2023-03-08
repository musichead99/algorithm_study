package algorithm_study.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {

    public static class Node {

        public int t;
        public int p;
    
        public Node(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        Node[] counsels = new Node[n + 1];
        int maxValue = 0; // 얻을 수 있는 이익의 최댓값을 항상 저장한다.

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            counsels[i] = new Node(t, p);
        }

        /* 리스트를 거꾸로 탐색하며 다이나믹프로그래밍 시작 */
        for(int i = n - 1; i >= 0; i--) {
            Node tmp = counsels[i];

            /* 만약 해당 상담 일정이 퇴사 전에 수행 가능하다면 */
            if(tmp.t + i < n + 1) {
                /* 해당 상담 일정을 잡았을 때 얻을 수 있는 이익과 현재 저장된 최대 이익값을 비교 */
                dp[i] = Math.max(dp[tmp.t + i] + tmp.p, maxValue);
                maxValue = dp[i]; // 이익의 최댓값
            } else {
                dp[i] = maxValue;
            }
        }

        System.out.println(maxValue);
    }
}
