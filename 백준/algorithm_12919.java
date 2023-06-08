import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_12919 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        dfs(t, s);

        System.out.println(0);
    }

    /* s -> t는 경우의 수가 너무 많아지기 때문에 t -> s를 탐색한다. */
    public static void dfs(String start, String end) {
        if(start.equals(end)) {
            System.out.println(1);
            System.exit(0);
        }

        if(start.length() == 0) {
            return;
        }

        if(start.charAt(start.length() - 1) == 'A') {
            dfs(start.substring(0, start.length() - 1), end);
        } 
        
        if(start.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(start);
            sb.reverse();
            dfs(sb.toString().substring(0, start.length() - 1), end);
        }
    }
}
