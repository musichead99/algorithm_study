import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String l = st.nextToken();
        String r = st.nextToken();

        if(l.length() != r.length()) {
            System.out.println(0);
            System.exit(0);
        }

        int count = 0;
        for(int i = 0; i < l.length(); i++) {
            if(l.charAt(i) != r.charAt(i)) {
                break;
            }

            if(l.charAt(i) == '8') {
                count++;
            }
        }

        System.out.println(count);
    }
}
