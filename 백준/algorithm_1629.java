import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 곱셈 */
public class algorithm_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(customMod(a,b,c));
    }

    public static long customMod(int a, int b, int c) {
        if(b == 0) {
            return 1;
        }

        long n = customMod(a, b / 2, c); // ? 
        if(b % 2 == 0) { // 짝수
            return n * n % c;
        } else { // 홀수
            return (n * n % c) * a % c;
        }
    }
}
