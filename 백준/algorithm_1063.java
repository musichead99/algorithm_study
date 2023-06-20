import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_1063 {

    private static final int MAX_RANGE = 9;
    private static int[][] map = new int[MAX_RANGE][MAX_RANGE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String kingCoord = st.nextToken();
        int kingX = kingCoord.charAt(1) - 48;
        kingX = MAX_RANGE - kingX;
        int kingY = kingCoord.charAt(0) - 64;
        map[kingX][kingY] = 1;

        String stoneCoord = st.nextToken();
        int stoneX = stoneCoord.charAt(1) - 48;
        stoneX = MAX_RANGE - stoneX;
        int stoneY = stoneCoord.charAt(0) - 64;
        map[stoneX][stoneY] = 2;

        int n = Integer.parseInt(st.nextToken());

        while(n-- > 0) {
            String move = br.readLine();
            int dx = 0;
            int dy = 0;

            switch(move) {
                case "R":
                    dy++;
                    break;
                case "L":
                    dy--;
                    break;
                case "B":
                    dx++;
                    break;
                case "T":
                    dx--;
                    break;
                case "RT":
                    dx--;
                    dy++;
                    break;
                case "LT":
                    dx--;
                    dy--;
                    break;
                case "RB":
                    dx++;
                    dy++;
                    break;
                case "LB":
                    dx++;
                    dy--;
                    break;
            }
            
            int nx = kingX + dx;
            int ny = kingY + dy;

            /* 킹의 다음 위치가 맵을 벗어난다면 그 이동은 건너뛴다 */
            if(nx < 1 || ny < 1 || nx >= MAX_RANGE || ny >= MAX_RANGE) {
                continue;
            }

            // 킹이 이동할 위치가 돌이 있는 위치라면 돌의 다음 위치도 확인
            if(map[nx][ny] == 2) {
                int stoneNx = stoneX + dx;
                int stoneNy = stoneY + dy;

                // 돌의 다음 위치가 맵을 벗어난다면 그 이동은 건너뛴다
                if(stoneNx < 1 || stoneNy < 1 || stoneNx >= MAX_RANGE || stoneNy >= MAX_RANGE) {
                    continue;
                }

                // 맵을 벗어나지 않는다면 돌을 이동시킨다.
                map[stoneNx][stoneNy] = 2;
                stoneX = stoneNx;
                stoneY = stoneNy;
            }

            // 킹을 이동시킨다.
            map[nx][ny] = 1;
            kingX = nx;
            kingY = ny;
        }

        System.out.print((char) (kingY + 64));
        System.out.println(MAX_RANGE - kingX);
        System.out.print((char) (stoneY + 64));
        System.out.println(MAX_RANGE - stoneX);
    }
}