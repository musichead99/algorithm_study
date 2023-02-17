package algorithm_study.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음료수_얼려_먹기 {

    static int n;
    static int m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        /* 얼음 틀 입력받기 */
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        br.close();

        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(dfs(map, i, j)) {
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }

    public static boolean dfs(int[][] map, int x, int y) {
        
        /* 현재 좌표가 맵을 벗어날 경우 */
        if(x <= -1 || y <= -1 || x >= n || y >= n) {
            return false;
        }

        /* 만약 이 좌표를 아직 방문하지 않았다면 */
        if(map[x][y] == 0) {
            map[x][y] = 1; // 방문표시

            /* 현재 좌표의 상하좌우로 탐색 시작 */
            dfs(map, x - 1, y);
            dfs(map, x, y - 1);
            dfs(map, x + 1, y);
            dfs(map, x, y + 1);
            return true;
        }

        return false;
    }
}
