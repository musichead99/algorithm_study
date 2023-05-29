import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long s = Integer.parseInt(st.nextToken());
        long[] arr = new long[n + 1]; // int로 선언 시 오버플로우 발생

        st = new StringTokenizer(br.readLine());
        arr[1] = Integer.parseInt(st.nextToken());

        for(int i = 2; i <= n ; i++) {
            arr[i] += arr[i - 1] + Long.parseLong(st.nextToken());
        }

        int result = Integer.MAX_VALUE;

        /* 투포인터 알고리즘 */
        int start = 1;
        int end = 1;
        while(end <= n) { // end값이 최대 n을 넘지 않도록 조건 지정
            if(arr[end] - arr[start - 1] >= s) { // 두 구간 사이의 합이 s보다 크거나 같다면
                result = Math.min(result, end - start + 1); // 구간 길이의 최솟값 갱신
                start++; // 더 작은 구간이 존재하나 탐색하기 위해 포인터 조정
            } else if (arr[end] - arr[start - 1] < s){
                end++; // 목표값 s를 찾기 위해 end값 조정
            }
        }

        result = result == Integer.MAX_VALUE ? 0 : result;

        System.out.println(result);
    }
}
