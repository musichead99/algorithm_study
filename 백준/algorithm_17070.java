import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class algorithm_17070 { 

    static int n;
    static int[][] map;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);
        
        System.out.println(count);

    }

    /* direcstion = 0 : 가로, 1 : 세로, 2 : 대각선 */
    public static void dfs(int r, int c, int direction) {
        if(r == n - 1 && c == n - 1) {
            count++;
            return;
        }

        switch(direction) {
            case 0:
                if(c + 1 < n && map[r][c + 1] != 1) dfs(r, c + 1, 0);
                break;
            
            case 1:
                if(r + 1 < n && map[r + 1][c] != 1) dfs(r + 1, c, 1);
                break;

            case 2:
                if(c + 1 < n && map[r][c + 1] != 1) dfs(r, c + 1, 0);
                if(r + 1 < n && map[r + 1][c] != 1) dfs(r + 1, c, 1);
                break;
        }

        if(c + 1 < n && r + 1 < n && map[r][c + 1] != 1 && map[r + 1][c] != 1 && map[r + 1][c + 1] != 1) {
            dfs(r + 1, c + 1, 2);
        }
    }
}