import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class algorithm_1987 {

    private static char[][] board;
    private static Map<Character, Integer> map;
    private static int result = 0;
    private static int r;
    private static int c;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        map = new LinkedHashMap<>();

        for(int i = 0; i < r; i++) {
            String temp = br.readLine();
            for(int j = 0; j < c; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        dfs(0, 0, 0);

        System.out.println(result);

    }

    private static void dfs(int x, int y, int count) {
        if(map.containsKey(board[x][y])) {
            result = Math.max(result, count);
            return;
        }
        
        map.put(board[x][y], 0);
        count++;
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx > -1 && nx < r && ny > -1 && ny < c) {
                dfs(nx, ny, count);
            }
        }
        map.remove(board[x][y]);
    }
}