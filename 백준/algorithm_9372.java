import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_9372 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        int[] sum = new int[1001];

        sum[1] = 3; // (1, 0), (0, 1), (1, 1)

        for(int i = 2; i < 1001; i++) { // 보이는 점의 개수는 재활용 가능하므로 미리 계산해둘 수 있다.
            int count = 0;
            for(int j = 1; j < i; j++) {
                if(gcd(i, j) == 1) {
                    count++;
                }
            }
            sum[i] = sum[i - 1] + count * 2;
        }

        while(c-- > 0) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(sum[n]);
        }
    }

    public static int gcd(int a, int b) {
        int r = a % b;
        if(r == 0) {
            return b;
        }

        return gcd(b, r);
    }
}
