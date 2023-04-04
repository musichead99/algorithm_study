package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_1780 {

    static int[] numCount = {0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        devideAndConquer(0, 0, n, map);

        for(int i = 0; i < 3; i++) {
            System.out.println(numCount[i]);
        }
    }

    public static void devideAndConquer(int x, int y, int len, int[][] map) {
        int value = map[x][y];

        int count = 0;

        loop: 
        for(int i = x; i < len + x; i++) {
            for(int j = y; j < len + y; j++) {
                if(map[i][j] != value) break loop;
                count++;
            }
        }

        /* 종이가 모두 같은 수로 되어 있다면 */
        if(count == len*len) {
            numCount[value + 1]++;
        }
        /* 종이가 모두 같은 수로 되어있지 않다면 같은 크기의 종이 9개로 잘라서 다시 탐색한다 */
        else {
            int step = len / 3;
            for(int i = x; i < len + x; i+= step) {
                for(int j = y; j< len + y; j+= step) {
                    devideAndConquer(i, j, step, map);
                }
            }
        }
    }
}
