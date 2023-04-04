package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_2630 {

    static int[] paperCount = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] paper = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        devideAndConquer(0, 0, n, paper);

        for(int i = 0; i < 2; i++) {
            System.out.println(paperCount[i]);
        }

    }

    public static void devideAndConquer(int r, int c, int len, int[][] paper) {
        int value = paper[r][c];

        int count = 0;
        Loop:
        for(int i = r; i < r + len; i++) {
            for(int j = c; j < c + len; j++) {
                if(paper[i][j] != value) break Loop;
                count++;
            }
        }

        if(count == len*len) {
            paperCount[value]++;
            return;
        } else {
            int step = len / 2;
            for(int i = r; i < r + len; i += step) {
                for(int j = c; j < c + len; j += step) {
                    devideAndConquer(i, j, step, paper);
                }
            }
        }
    }
}