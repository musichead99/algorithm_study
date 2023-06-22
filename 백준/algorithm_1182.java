import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_1182 {

    private static int n;
    private static int s;
    private static int count = 0;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            dfs(arr[i], i);
        }

        System.out.println(count);
    }

    public static void dfs(int sum, int index) {
        if(sum == s) {
            count++;
        }

        for(int i = index + 1; i < n; i++) {
            dfs(sum + arr[i], i);
        }
    }
}
