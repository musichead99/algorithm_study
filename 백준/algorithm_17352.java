import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_17352 {

    private static class DisjointSet {
        private int[] parent;

        public DisjointSet(int num) {
            parent = new int[num + 1];

            for(int i = 1; i < num + 1; i++) {
                parent[i] = i;
            }
        }

        public void union(int a, int b) {
            int aParent = find(a);
            int bParent = find(b);

            if(aParent < bParent) {
                parent[bParent] = aParent;
            } else {
                parent[aParent] = bParent;
            }
        }

        public int find(int a) {
            if(parent[a] != a) {
                return find(parent[a]);
            }

            return a;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        DisjointSet disjointSet = new DisjointSet(n);

        for(int i = 0; i < n - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            disjointSet.union(start, end);
        }

        for(int i = 1; i < n + 1; i++) {
            int node = disjointSet.find(i);

            if(node == i) {
                sb.append(node + " ");
            }
        }

        System.out.println(sb);
    }
}
