package algorithm_study.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 감시피하기 {

    private static class Teacher {
        public int x;
        public int y;

        Teacher(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] map;
    static int n;
    static String result = "NO";
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static List<Teacher> teachers = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'T') {
                    teachers.add(new Teacher(i, j));
                }
            }
        }

        dfs(0);

        System.out.println(result);
    }

    private static void dfs(int walls) {
        if(walls == 3) {
            searching();
            return;
        }

        /* 벽 설치 */
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 'X') {
                    map[i][j] = 'O';
                    dfs(walls + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    private static void searching() {
        for(Teacher t : teachers) {
            for(int i = 0; i < 4; i++) {
                int tx = t.x;
                int ty = t.y;
                while(tx >= 0 && ty >= 0 && tx < n && ty < n) {
                    if(map[tx][ty] == 'O') {
                        break;
                    }

                    if(map[tx][ty] == 'S') {
                        return;
                    }
                    tx += dx[i];
                    ty += dy[i];
                }
            }
        }
        result = "YES";
    }
}
