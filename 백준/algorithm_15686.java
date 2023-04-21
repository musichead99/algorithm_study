import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 치킨배달 */
public class algorithm_15686 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;
    static int result = Integer.MAX_VALUE;
    static List<Node> houses = new ArrayList<>();
    static List<Node> chickenHouses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n + 1; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                if(tmp == 1) {
                    houses.add(new Node(i, j));
                } else if(tmp == 2) {
                    chickenHouses.add(new Node(i, j));
                }
            }
        }
        boolean[] check = new boolean[chickenHouses.size()]; // 남겨 둘 치킨집을 나타낼 배열

        backtracking(0, 0, check);

        System.out.println(result);
    }

    public static void backtracking(int depth, int start, boolean[] check) {
        if(depth == m) {
            
            int chickenDistance = 0;

            for(int i = 0; i < houses.size(); i++) {
                int dist = Integer.MAX_VALUE;
                for(int j = 0; j < chickenHouses.size(); j++) {
                    if(check[j]) {
                        Node house = houses.get(i);
                        Node chickenHouse = chickenHouses.get(j);
                        int tmp = Math.abs(house.x - chickenHouse.x) + Math.abs(house.y - chickenHouse.y);
                        dist = Math.min(tmp, dist);
                    }
                }  
                chickenDistance += dist;
            }

            result = Math.min(result, chickenDistance);
        }

        for(int i = start; i < chickenHouses.size(); i++) {
            if(!check[i]) {
                check[i] = true;
                backtracking(depth + 1, i, check);
                check[i] = false;
            }
        }
    }
}
