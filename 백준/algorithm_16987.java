import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_16987 {

    private static class Egg {
        int weight;
        int durability;

        public Egg(int weight, int durability) {
            this.weight = weight;
            this.durability = durability;
        }
    }

    private static int result = 0;
    private static Egg[] eggs;
    private static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        eggs = new Egg[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            eggs[i] = new Egg(weight, durability);
        }

        dfs(0, 0);

        System.out.println(result);
    }

    private static void dfs(int index, int count) {
        if(index == n) {
            result = Math.max(result, count);
            return;
        }

        if(eggs[index].durability <= 0) {
            dfs(index + 1, count);
            return;
        }

        boolean flag = true;
        for(int i = 0; i < n; i++) {
            if(index == i || eggs[i].durability <= 0) continue;

            eggs[i].durability -= eggs[index].weight;
            eggs[index].durability -= eggs[i].weight;

            int ncount = 0;
            if(eggs[i].durability <= 0) {
                ncount++;
            }

            if(eggs[index].durability <= 0) {
                ncount++;
            }

            flag = false;
            dfs(index + 1, count + ncount);

            eggs[i].durability += eggs[index].weight;
            eggs[index].durability += eggs[i].weight;
        }

        if(flag) {
            dfs(index + 1, count);
        }
    }
}