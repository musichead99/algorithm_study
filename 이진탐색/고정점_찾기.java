package algorithm_study.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 고정점_찾기 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch(0, n - 1, arr));

    }

    /* 이진 탐색 메소드 */
    public static int binarySearch(int start, int end, int[] arr) {
        if(start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        /* 인덱스가 가리키는 값과 인덱스 값이 같다면 해당 인덱스 반환 */
        if(mid == arr[mid]) {
            return mid;
        } else if(mid > arr[mid]) { // 인덱스가 가리키는 값이 인덱스 값보다 작다면 오른쪽 탐색 
            return binarySearch(mid + 1, end, arr);
        } else { // 인덱스가 가리키는 값이 인덱스 값보다 크다면 왼쪽 탐색
            return binarySearch(start, mid - 1, arr);
        }
    }
}
