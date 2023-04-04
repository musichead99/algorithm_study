package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int count = 0;
        int[] memo = new int[m]; // 특정 시점까지의 "OI"의 개수를 메모이제이션
        for(int i = 1; i < m - 1; i++) {
            if(str.charAt(i) == 'O' && str.charAt(i + 1) == 'I') {
                memo[i + 1] = memo[i - 1] + 1;

                if(memo[i + 1] >= n) {
                    if(str.charAt(i - n*2 + 1) == 'I') { // 맨 앞의 문자가 'I'라면 조건 성립
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
