import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_19941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] parsedTable = br.readLine().toCharArray();
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(parsedTable[i] == 'H' || parsedTable[i] == 'E') {
                continue;
            }

            for(int j = -k; j <= k; j++) {
                int toEat = i + j;

                if(toEat < 0 || toEat >= n) {
                    continue;
                }

                if(parsedTable[toEat] == 'H') {
                    count++;
                    parsedTable[toEat] = 'E';
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
