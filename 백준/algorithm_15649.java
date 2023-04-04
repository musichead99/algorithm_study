package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_15649 {

    static int[] arr;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        dfs(N, M);
    }

    private static void dfs(int end, int count) {
        if(count == 0) {
            for(int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= end; i++) {
            if(isPossible(i, count)) {
                arr[M - count] = i;
                dfs(end, count-1);
            }
        }
    }

    private static boolean isPossible(int n, int count) {
        for(int i = 0; i < M - count; i++) {
            if(arr[i] == n) return false;
        }
        return true;
    }
}
