import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_15650 {

    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(1, 0);

        System.out.print(sb);
    }

    public static void dfs(int now, int depth) {
        if(depth == m) {
            for(int node : arr) {
                sb.append(node + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i = now; i < n + 1; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
