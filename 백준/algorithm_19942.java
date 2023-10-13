import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class algorithm_19942 {

    private static class Ingrediant {
        public int p;
        public int s;
        public int f;
        public int v;
        public int price;

        public Ingrediant(
            int p, int s, int f, int v, int price) {
            this.p = p;
            this.s = s;
            this.f = f;
            this.v = v;
            this.price = price;
        }
    }

    private static int n;
    private static Ingrediant[] ingrediants;

    private static int mp;
    private static int mf;
    private static int ms;
    private static int mv;

    private static int minPrice = Integer.MAX_VALUE;
    private static ArrayList<Integer> numList = new ArrayList<>();


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        ingrediants = new Ingrediant[n + 1];

        st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int protein = Integer.parseInt(st.nextToken());
            int fat = Integer.parseInt(st.nextToken());
            int carbohydrate = Integer.parseInt(st.nextToken());
            int vitamin = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            ingrediants[i] = new Ingrediant(protein, carbohydrate, fat, vitamin, price);
        }

        for(int i = 1; i < n + 1; i++) {
            ArrayList<Integer> nums = new ArrayList<>();
            nums.add(i);

            dfs(i, new Ingrediant(
                ingrediants[i].p,
                ingrediants[i].s, 
                ingrediants[i].f,
                ingrediants[i].v,
                ingrediants[i].price),
                nums
            );
            nums.remove(0);
        }

        if(minPrice == Integer.MAX_VALUE) {
            minPrice = -1;
        } 
        System.out.println(minPrice);

        if(!numList.isEmpty()) {
            for(int num : numList) {
                System.out.print(num + " ");
            }
        }
    }

    private static void dfs(int index, Ingrediant choices, ArrayList<Integer> nums) {
        if(choices.price > minPrice) {
            return;
        }

        if(choices.p >= mp && choices.s >= ms && choices.f >= mf && choices.v >= mv
            && choices.price < minPrice) {
            minPrice = choices.price;
            numList.clear();
            numList.addAll(nums);
            return;
        }

        for(int i = index + 1; i < n + 1; i++) {
            nums.add(i);
            dfs(i, 
                new Ingrediant(
                    choices.p + ingrediants[i].p, 
                    choices.s + ingrediants[i].s,
                    choices.f + ingrediants[i].f,
                    choices.v + ingrediants[i].v,
                    choices.price + ingrediants[i].price
                    ), 
                nums);
            nums.remove(nums.size() - 1);
        }
    }
}
