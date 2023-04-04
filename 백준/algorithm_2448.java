package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_2448 {

    static char[][] starMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        starMap = new char[N][N*2-1];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N * 2 - 1; j++) {
                starMap[i][j] = ' ';
            }
        }

        drawStars(0, N-1, N);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N * 2 - 1; j++) {
                sb.append(starMap[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void drawStars(int i, int j, int N) {
        if(N == 3) {
            starMap[i][j] = '*';
            starMap[i + 1][j - 1] = '*';
            starMap[i + 1][j + 1] = '*';
            starMap[i + 2][j - 2] = '*';
            starMap[i + 2][j - 1] = '*';
            starMap[i + 2][j] = '*';
            starMap[i + 2][j + 1] = '*';
            starMap[i + 2][j + 2] = '*';
        } else {
            drawStars(i, j, N / 2);
            drawStars(i + N / 2, j - N / 2, N / 2);
            drawStars(i + N / 2, j + N / 2, N / 2);
        }
    }
}