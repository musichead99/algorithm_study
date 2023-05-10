package algorithm_study.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        dfs(t, s);
        System.out.println(0);
    }

    private static void dfs(String start, String end) {
        if(start.equals(end)) {
            System.out.println(1);
            System.exit(0);
        }

        if(start.length() == 0) {
            return;
        }

        if(start.charAt(start.length() - 1) == 'A') {
            dfs(start.substring(0, start.length() - 1), end);
        } else {
            StringBuffer sb = new StringBuffer(start.substring(0, start.length() - 1));
            dfs(sb.reverse().toString(), end);
        }
    }
}
