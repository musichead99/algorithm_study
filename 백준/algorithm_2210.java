import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class algorithm_2210 {

    private static final int len = 5;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static ArrayList<Integer> results = new ArrayList<>();
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[len][len];

        for(int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < len; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                dfs(i, j, String.valueOf(map[i][j]), 1);
            }
        }

        System.out.println(results.size());
    }

    public static void dfs(int x, int y, String num, int depth) {
        if(depth == 6) {
            int n = Integer.parseInt(num);

            if(!results.contains(n)) {
                results.add(n);
            }

            return;
        }

        for(int i = 0; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= len || ny >= len) {
                continue;
            }

            dfs(nx, ny, num + map[nx][ny], depth + 1);
        }
    }
}
