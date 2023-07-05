import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class algorithm_15657 {

    private static int n;
    private static int m;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0, new ArrayList<>());
    }

    private static void dfs(int index, int depth, List<Integer> list) {
        if(depth == m) {
            print(list);
            return;
        }

        for(int i = index; i < n; i++) {
            list.add(arr[i]);
            dfs(i, depth + 1, list);
            list.remove(list.size() - 1);
        }
    }

    private static void print(List<Integer> list) {
        for(int node : list) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
