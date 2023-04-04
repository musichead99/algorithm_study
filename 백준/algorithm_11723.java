package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int bit = 0;

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();

            if(str.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                bit |= (1 << (x - 1));
            } 
            else if(str.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                
                sb.append((bit & (1 << (x - 1))) == 0 ? "0\n" : "1\n");

            } 
            else if(str.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                bit &= ~(1 << (x - 1));
            } 
            else if(str.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                bit ^= (1 << (x - 1));
            } 
            else if(str.equals("all")) {
                bit |= (int) (Math.pow(2, 20) - 1);
            } 
            else if(str.equals("empty")) {
                bit = 0;
            }
        }

        System.out.println(sb);
    }
}
