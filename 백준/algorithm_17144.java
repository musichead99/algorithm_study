import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_17144 {

    static int r;
    static int c;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c];
        int sum = 0;
        int airCleaner = -1;

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == -1 && airCleaner == -1) {
                    airCleaner = i;
                }
            }
        }

        /* 확산과 공기청정기 작동 과정 */
        while(t-- > 0) {
            map = spread(map);
            airCleanerOn(map, airCleaner);
        }

        /* 방에 남아있는 미세먼지의 양 계산 */
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] > -1) {
                    sum += map[i][j];
                }
            }
        }

        System.out.println(sum);
    }

    /* 확산 */
    public static int[][] spread(int[][] map) {
        int[][] spreadedMap = new int[r][c];

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                int count = 0;
                int spreadedDust;

                if(map[i][j] == 0) {
                    continue;
                } else if (map[i][j] == -1) {
                    spreadedMap[i][j] = -1;
                    continue;
                }

                spreadedDust = map[i][j] / 5; // 확산될 미세먼지의 양

                for(int k = 0; k < 4; k++) { // 상하좌우 4방향 모두 확인
                    int nr = i + dx[k];
                    int nc = j + dy[k];

                    // 확인한 좌표가 맵을 넘어가지 않고, 공기청정기 위치가 아니라면 확산
                    if(nr > -1 && nc > -1 && nr < r && nc < c && map[nr][nc] != -1) { 
                        spreadedMap[nr][nc] += spreadedDust;
                        count++; // 확산한 수
                    }
                }
                spreadedMap[i][j] += (map[i][j] - spreadedDust * count); // 남은 먼지 개수 계산
            }
        }

        return spreadedMap;
    }

    /* 공기청정기 가동 */
    public static void airCleanerOn(int[][] map, int airCleaner) {
        int top = airCleaner;
        int down = airCleaner + 1;

        /* 공기청정기 위쪽 */
        for(int i = top - 1; i > 0; i--) { // 위에서 아래로 
            map[i][0] = map[i - 1][0];
        }
        for(int i = 0; i < c - 1; i++) { // 오른쪽에서 왼쪽으로
            map[0][i] = map[0][i + 1];
        }
        for(int i = 0; i < top; i++) { // 아래에서 위로
            map[i][c - 1] = map[i + 1][c - 1];
        }
        for(int i = c - 1; i > 1; i--) { // 왼쪽에서 오른쪽으로
            map[top][i] = map[top][i - 1];
        }
        map[top][1] = 0;

        /* 공기청청기 아래쪽 */
        for(int i = down + 1; i < r - 1; i++) { // 아래에서 위로
            map[i][0] = map[i + 1][0];
        }
        for(int i = 0; i < c - 1; i++) { // 오른쪽에서 왼쪽으로
            map[r - 1][i] = map[r - 1][i + 1];
        }
        for(int i = r - 1; i > down; i--) { // 위에서 아래로 
            map[i][c - 1] = map[i - 1][c - 1];
        }
        for(int i = c - 1; i > 1; i--) { // 왼쪽에서 오른쪽으로
            map[down][i] = map[down][i - 1];
        }
        map[down][1] = 0;
    }
}