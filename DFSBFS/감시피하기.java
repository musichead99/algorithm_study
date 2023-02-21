package algorithm_study.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Teacher {
    int x;
    int y;

    public Teacher(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 감시피하기 {
    static char[][] map;
    static int n;
    static String answer = "NO";
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new char[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0);

        System.out.println(answer);

    }

    /* 벽을 3개 세우는 경우의 수를 dfs탐색 */
    public static void dfs(int count) {
        if(count == 3) {
            search();
            return;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(map[i][j] == 'X') { // 'X'일 경우에만 벽 설치
                    map[i][j] = 'O';
                    dfs(count + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    /* 교사들이 학생들을 탐지하는 메소드 */
    public static void search() {

        /* 현재 맵에 위치한 교사들의 좌표를 리스트에 저장 */
        List<Teacher> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(map[i][j] == 'T') list.add(new Teacher(i, j));
            }
        }

        /* 각 교사별로 탐색할 수 있는 모든 방향으로 탐색 시작 */
        for(Teacher teacher : list) {
            for(int i = 0; i < 4; i++) {
                int nx = teacher.x;
                int ny = teacher.y;
                while(nx > 0 && ny > 0 && nx <= n && ny <= n) {
                    if(map[nx][ny] == 'O') break; // 벽을 발견했다면 다음 방향으로 탐색
                    
                    if(map[nx][ny] == 'S') return; // 학생을 발견했다면 탐색 종료

                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }
        answer = "YES"; // 탐색을 모두 마쳐도 학생을 발견하지 못했을 경우 "YES"
        return;
    }
}
