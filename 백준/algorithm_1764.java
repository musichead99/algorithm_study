package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algorithm_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        /* 듣도 못한 사람 */
        String[] people1 = new String[n];
        for(int i = 0; i < n; i++) {
            people1[i] = br.readLine();
        }

        /* 보도 못한 사람 */
        String[] people2 = new String[m];
        for(int i = 0; i < m; i++) {
            people2[i] = br.readLine();
        }

        Arrays.sort(people1);
        Arrays.sort(people2);

        int count = 0;
        for(int i = 0; i < n; i++) {
            if(binarySearch(0, people2.length - 1, people2, people1[i])) {
                sb.append(people1[i]+"\n");
                count++;
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }

    /* 이진 탐색을 통해 듣도 못한 사람이 보도 못한 사람의 목록에도 있는지를 확인한다 */
    private static boolean binarySearch(int start, int end, String[] arr, String target) {
        int mid = (start + end) / 2;

        /* 듣도 못한 사람이나 보도 못한 사람은 아님 */
        if(start > end) {
            return false;
        }

        /* 듣보잡 발견 */
        if(arr[mid].equals(target)) {
            return true;
        } else if(arr[mid].compareTo(target) < 0) {
            return binarySearch(mid + 1, end, arr, target);
        } else {
            return binarySearch(start, mid - 1, arr, target);
        }
    }
}
