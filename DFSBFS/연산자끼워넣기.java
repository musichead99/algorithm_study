package algorithm_study.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

    static int[] arr;
    static int n;
    // static int[] operators;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        dfs(1, arr[0], operators);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int now, int value, int[] ops) {

        if(now == n) {
            max = Math.max(value, max);
            min = Math.min(value, min);
            return;
        }

        
        if(ops[0] > 0) {
            ops[0]--;
            dfs(now + 1, value + arr[now], ops);
            ops[0]++;
        } 
        if(ops[1] > 0) {
            ops[1]--;
            dfs(now + 1, value - arr[now], ops);
            ops[1]++;
        } 
        if(ops[2] > 0) {
            ops[2]--;
            dfs(now + 1, value * arr[now], ops);
            ops[2]++;
        } 
        if(ops[3] > 0) {
            ops[3]--;
            dfs(now + 1, value / arr[now], ops);
            ops[3]++;
        }
    }
}