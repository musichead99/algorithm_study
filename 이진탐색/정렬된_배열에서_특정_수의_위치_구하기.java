package algorithm_study.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정렬된_배열에서_특정_수의_위치_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /* x가 나오는 최초의 인덱스와 가장 마지막의 인덱스를 탐색 */
        int first = firstIndexBinarySearch(0, n - 1, arr, x);
        int last = lastIndexBinarySearch(0, n - 1, arr, x);
        
        if(first == -1 || last == -1) {
            System.out.println(-1);
        } else {
            System.out.println(last - first + 1);
        }
    }

    /* x가 등장하는 최초의 인덱스를 탐색하는 이진 탐색 메소드 */
    public static int firstIndexBinarySearch(int start, int end, int[] arr, int x) {
        if(start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        /* mid값이 0이거나 mid가 x가 등장하는 최초 인덱스일 경우 인덱스값 반환 */
        if(mid == 0 || arr[mid - 1] < x && arr[mid] == x) {
            return mid;
        } else if (arr[mid] >= x) {
            return firstIndexBinarySearch(start, mid - 1, arr, x);
        } else {
            return firstIndexBinarySearch(mid + 1, end, arr, x);
        }
    }

    /* x가 등장하는 가장 마지막의 인덱스를 탐색하는 이진 탐색 메소드 */
    public static int lastIndexBinarySearch(int start, int end, int[] arr, int x) {
        if(start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        /* mid값이 마지막 인덱스이거나 mid가 x가 등장하는 마지막 인덱스일 경우 인덱스값 반환 */
        if(mid == arr.length - 1 || arr[mid + 1] > x && arr[mid] == x) {
            return mid;
        } else if (arr[mid] > x) {
            return lastIndexBinarySearch(start, mid - 1, arr, x);
        } else {
            return lastIndexBinarySearch(mid + 1, end, arr, x);
        }
    }
}
