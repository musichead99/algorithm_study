package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class algorithm_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 압축된 좌표를 출력할 때 원래 입력받았던 순서가 필요하므로 복사해서 정렬
        int[] arrClone = arr.clone(); 
        Arrays.sort(arrClone);

        HashMap<Integer, Integer> map = new HashMap<>();

        // 중복된 수를 고려하여 랭킹을 매기려면 rank는 따로 카운트 해야 한다.
        int rank = 0;
        for(int node : arrClone) {
            if(!map.containsKey(node)) {
                map.put(node, rank);
                rank++; 
            } 
        }

        for(int node : arr) {
            sb.append(map.get(node) + " ");
        }

        System.out.println(sb);
    }
}
