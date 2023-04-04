package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String result = "yes";
            String n = br.readLine();
            if(n.equals("0")) break;

            int len = n.length() / 2;
            for(int i = 0; i <= len; i++) {
                if(n.charAt(i) != n.charAt(n.length() - i - 1)) {
                    result = "no";
                }
            }

            System.out.println(result);
        }
    }
}
