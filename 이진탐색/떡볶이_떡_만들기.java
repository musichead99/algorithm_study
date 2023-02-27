package algorithm_study.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡볶이_떡_만들기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dduck = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            dduck[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dduck);
        
        int result = binarySearch(0, dduck[n - 1], dduck, m);
        System.out.println(result);
    }

    /* 재귀적으로 구현한 이진 탐색 메소드 */
    public static int binarySearch(int start, int end, int[] dduck, int target) {
        if(start > end) {
            return -1;
        } 

        int mid = (start + end) / 2;

        /* mid가 절단기의 길이를 뜻하고, 해당 절단기로 잘랐을 때 가져갈 수 있는 떡의 총 길이와 손님이 요청한 길이를 비교  */
        if(dduckLength(dduck, mid) == target) {
            return mid;
        } else if(dduckLength(dduck, mid) > target) { // 만약 손님이 요청한 길이보다 길다면 절단기의 길이를 늘린다.
            return binarySearch(mid + 1, end, dduck, target);
        } else { // 만약 손님이 요청한 길이보다 짧다면 절단기의 길이를 줄인다.
            return binarySearch(start, mid - 1, dduck, target);
        }
    }

    /* 손님이 가져갈 수 있는 떡의 길이를 구하는 메소드 */
    public static int dduckLength(int[] dduck, int cutter) {
        int sum = 0;

        for(int i = 0; i < dduck.length; i++) {
            if(dduck[i] - cutter > 0) sum += dduck[i] - cutter;
        }

        return sum;
    }
}
