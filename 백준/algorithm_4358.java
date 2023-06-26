import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class algorithm_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new TreeMap<>();
        int count = 0;

        while(true) {
            String str = br.readLine();

            if( str == null || str.length() == 0) {
                break;
            }

            map.put(str, map.getOrDefault(str, 0) + 1);

            count++;
        }

        Iterator<String> keys = map.keySet().iterator();

        while(keys.hasNext()) {
            String key = keys.next();

            int treeCount = map.get(key);
            float percent = (float) treeCount / (float) count * 100;

            sb.append(key + " " + String.format("%.4f", percent) + "\n");
        }

        System.out.println(sb);
    }
}
