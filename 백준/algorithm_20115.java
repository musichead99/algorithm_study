import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class algorithm_20115 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Float> list = new ArrayList<>(n);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            list.add(Float.parseFloat(st.nextToken()));
        }

        Collections.sort(list);
        while(list.size() != 1) {
            float min = list.remove(0);
            float max = list.remove(list.size() - 1);

            float newDrink = max + (min / 2);
            list.add(newDrink);
        }

        System.out.println(list.get(0));
    }
}