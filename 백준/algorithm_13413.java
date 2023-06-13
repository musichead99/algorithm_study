import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_13413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            char[] start = br.readLine().toCharArray();
            char[] target = br.readLine().toCharArray();
            int count = 0;
            int bCount = 0;
            int wCount = 0;

            for(int i = 0; i < n; i++) {
                if(start[i] != target[i]) {
                    if(start[i] == 'B') {
                        bCount++;
                    } else {
                        wCount++;
                    }
                }
            }

            count = Math.max(wCount, bCount);

            System.out.println(count);
        }
    }
}
