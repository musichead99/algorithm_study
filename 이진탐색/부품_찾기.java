package algorithm_study.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부품_찾기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] Parts = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            Parts[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Parts); // 이진탐색을 위해선 탐색할 리스트가 정렬되어 있어야 함

        int m = Integer.parseInt(br.readLine());
        int[] required = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            required[i] = Integer.parseInt(st.nextToken());
        }

        /* 해당 부품을 찾았다면 "yes" 아니면 "no" */
        for(int requiredPart : required) {
            if(binarySearch(0, n, Parts, requiredPart)) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }

    }

    /* 이진 탐색 알고리즘 */
    public static boolean binarySearch(int start, int end, int[] Parts, int required) {
        if(start > end) {
            return false;
        }

        int mid = (start + end) / 2;

        if(Parts[mid] == required) {
            return true;
        } else if(Parts[mid] > required) {
            return binarySearch(start, mid - 1, Parts, required);
        } else {
            return binarySearch(mid + 1, end, Parts, required);
        }
    }
}
