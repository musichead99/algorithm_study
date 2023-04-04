package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_9663 {

    static int count = 0;
    static int[] queens;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();

        int[][] map = new int[N][N];
        queens = new int[N];

        n_queen(map, 0);

        System.out.println(count);
    }

    private static void n_queen(int[][] map, int row) {

        if(row == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(isPossible(map, row, i)) {
                    queens[row] = i;
                    n_queen(map, row + 1);
            } 
        }
    }

    private static boolean isPossible(int[][]map, int row, int column) {

        for(int i = 0; i < row; i++) {
            if(Math.abs(i - row) == Math.abs(queens[i] - column) || column == queens[i]) {
                return false;
            } 
        }
        return true;
    }
}
