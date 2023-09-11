import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 1;

        for(int i = 0; ; i++) {
            start = start + (6 * i);

            if(n <= start) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
