import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_14503 {

    private static int n;
    private static int m;

    private static int r;
    private static int c;
    private static int direction;

    private static int[][] map;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            if(map[r][c] == 0) {
                cleanUp(r, c);
            }

            int pr = r;
            int pc = c;
            int tempd = direction;
            for(int i = 0; i < 4; i++) { // 반시계방향
                if(tempd == 0) {
                    tempd = 4 - 1;
                } else {
                    tempd--;
                }
                
                int nr = r + dx[tempd];
                int nc = c + dy[tempd];

                if(nextCheck(nr, nc)) {
                    direction = tempd;
                    r = nr;
                    c = nc;
                    break;
                }
            }

            if(pr == r && pc == c) { // 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
                int nr = r - dx[direction];
                int nc = c - dy[direction];

                if(!boundaryCheck(nr, nc)) {
                    break;
                } else {
                    r = nr;
                    c = nc;
                }
            }
        }

        System.out.println(count);
        
    }

    public static void cleanUp(int r, int c) {
        map[r][c] = -1;
        count++;
    }

    public static boolean nextCheck(int nr, int nc) {
        if(map[nr][nc] == 0) {
            return true;
        }
        
        return false;
    }

    public static boolean boundaryCheck(int nr, int nc) {
        if(map[nr][nc] == 1) {
            return false;
        }

        return true;
    }
}