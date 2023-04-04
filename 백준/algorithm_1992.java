package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 쿼드트리 */
public class algorithm_1992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for(int i= 0; i < n; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(tmp.charAt(j));
            }
        }

        devideAndConquer(0, 0, n, map);

    }

    public static void devideAndConquer(int x, int y, int len, int[][] map) {
        int value = map[x][y];
        int count = 0;

        Loop:
        for(int i = x; i < x + len; i++) {
            for(int j = y; j < y + len; j++) {
                if(map[i][j] != value) break Loop;
                count++;
            }
        }

        if(count == len*len) System.out.print(value);
        else {
            System.out.print("(");
            for(int i = x; i < x + len; i += len / 2) {
                for(int j = y; j < y + len; j += len / 2) {
                    devideAndConquer(i, j, len/2, map);
                }
            }
            System.out.print(")");
        }
    }
}