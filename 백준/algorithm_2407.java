import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class algorithm_2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger result = factorial(n).divide(factorial(m).multiply(factorial(n-m)));

        System.out.println(result);
    }

    public static BigInteger factorial(long num) {
        if(num == 1 || num == 0) return BigInteger.valueOf(1);

        return factorial(num - 1).multiply(BigInteger.valueOf(num));
    }
}
