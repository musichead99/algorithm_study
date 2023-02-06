package algorithm_study.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 모험가_길드 {
    public static void main(String[] args) throws IOException {

        /* n(모험가의 수) 파싱 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        /* adventurers(각 모험가의 공포도) 파싱 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] adventurers = new int[n];
        for(int i = 0; i < n; i++) {
            adventurers[i] = Integer.parseInt(st.nextToken());
        }

        /* 모험가들을 공포도 순으로 오름차순 정렬 */
        Arrays.sort(adventurers);

        /* 그룹의 수 계산 */
        int count = 0;
        int result = 0;
        for(int adventurer : adventurers) {
            count++;

            if(adventurer <= count) { // 그룹에 참여하는 모험가의 공포도가 그룹원의 수보다 작거나 같다면 그룹을 만든다.
                result++;
                count = 0;
            }
        }

        System.out.println(result);
    }
}
