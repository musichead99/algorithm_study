package algorithm_study.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /* 순서대로 덧셈 뺄셈 곱셈 나눗셈의 개수 */
        int[] op = new int[4]; 
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[1], op);

        System.out.println(max);
        System.out.println(min);
    }

    /* 연산자를 넣을 수 있는 모든 경우의 수를 재귀적으로 적용 */
    public static void dfs(int now, int value, int[] op) {

        /* 모든 연산 과정을 마쳤을 경우 max값과 min값 갱신 */
        if(arr.length - 1 == now) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        /* 각 연산자별 연산을 수행 */
        if(op[0] > 0) {
            op[0]--;
            dfs(now + 1, value + arr[now + 1], op);
            op[0]++;
        }
        if(op[1] > 0) {
            op[1]--;
            dfs(now + 1, value - arr[now + 1], op);
            op[1]++;
        }
        if(op[2] > 0) {
            op[2]--;
            dfs(now + 1, value * arr[now + 1], op);
            op[2]++;
        }
        if(op[3] > 0) {
            op[3]--;
            dfs(now + 1, value / arr[now + 1], op);
            op[3]++;
        }
    }
}