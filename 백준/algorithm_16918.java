import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_16918 {

    private static int r;
    private static int c;
    private static int n;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c];

        for(int i = 0; i < r; i++) {
            String temp = br.readLine();
            for(int j = 0; j < c; j++) {
                if(temp.charAt(j) == '.') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = 1;
                }
            }
        }
        n--;


        for(int i = 1; i <= n; i++) {
            if(i % 2 == 0) { // 폭탄 터질 타이밍
                boom(map);
            } else { // 폭탄 설치 타이밍
                setBomb(map);
            }
        }

        print(map);
    }

    private static void setBomb(int[][] map) {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] == -1) {
                    map[i][j] = 0; // 폭탄 설치
                } else { // 이미 설치된 폭탄이면 시간초 증가
                    map[i][j]++;
                }
            }
        }
    }

    private static void boom(int[][] map) {
        int[][] cloneMap = new int[r][c];

        for(int i = 0; i < r; i++) {
            cloneMap[i] = map[i].clone();
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] == 2) { // 터질 시간이 된 폭탄들 터뜨리기
                    cloneMap[i][j] = -1;

                    for(int k = 0; k < 4; k++) {
                        int nx = dx[k] + i;
                        int ny = dy[k] + j;

                        if(check(nx, ny)) {
                            cloneMap[nx][ny] = -1;
                        }
                    }

                    continue;
                } 

                if(cloneMap[i][j] != -1) { // 폭탄 시간초 갱신
                    cloneMap[i][j]++;
                }
            }
        }

        for(int i = 0; i < r; i++) {
            map[i] = cloneMap[i].clone();
        }
    }

    private static boolean check(int x ,int y) {
        if(x < 0 || y < 0 || x >= r || y >= c) {
            return false;
        } 

        return true;
    }

    private static void print(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] == -1) {
                    sb.append('.');
                } else {
                    sb.append('O');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
