package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Item implements Comparable<Item>{
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Item o) {
        return this.weight - o.weight;
    }

}

public class algorithm_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Item[] items = new Item[N + 1];
        int[][] dp = new int[N + 1][K + 1];

        items[0] = new Item(0, 0);

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            items[i] = new Item(weight, value);
        }

        Arrays.sort(items);

        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < K + 1; j++) {
                if(j >= items[i].weight) {
                    dp[i][j] = Math.max(items[i].value + dp[i - 1][j - items[i].weight], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
