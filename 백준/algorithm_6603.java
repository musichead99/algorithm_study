import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class algorithm_6603 {

    private static final StringBuilder sb = new StringBuilder();
    private static final int MAX_LENGTH = 6;
    private static int k;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if(k == 0) {
                break;
            }

            arr = new int[k];

            for(int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < k; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                dfs(1, i, list);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int depth, int index, List<Integer> resultList) {
        if(depth == MAX_LENGTH) {
            for(int num : resultList) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = index + 1; i < k; i++) {
            resultList.add(arr[i]);
            dfs(depth + 1, i, resultList);
            resultList.remove(resultList.size() - 1);
        }
    }
}