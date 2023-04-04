package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class algorithm_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> integerMap = new HashMap<>();
        HashMap<String, Integer> stringMap = new HashMap<>();

        for(int i = 1; i < n + 1; i++) {
            String str = br.readLine();
            integerMap.put(i, str);
            stringMap.put(str, i);
        }

        for(int i = 0; i < m; i++) {
            String str = br.readLine();

            if(str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                String pokemon = integerMap.get(Integer.parseInt(str));
                sb.append(pokemon + "\n");
            } else {
                sb.append(stringMap.get(str) + "\n");
            }
        }

        System.out.println(sb);
    }
}
