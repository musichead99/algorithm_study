import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int[][] map = new int[n + 1][3];
        int[][] dpMax = new int[n + 1][3];
        int[][] dpMin = new int[n + 1][3];

        for(int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < 3; j++) {
                if(j == 0) {
                    dpMax[i][j] = Math.max(map[i][j] + dpMax[i - 1][j], map[i][j] + dpMax[i - 1][j + 1]);
                    dpMin[i][j] = Math.min(map[i][j] + dpMin[i - 1][j], map[i][j] + dpMin[i - 1][j + 1]);
                } else if(j == 1) {
                    dpMax[i][j] = Math.max(Math.max(map[i][j] + dpMax[i - 1][j - 1], map[i][j] + dpMax[i - 1][j]), map[i][j] + dpMax[i - 1][j + 1]);
                    dpMin[i][j] = Math.min(Math.min(map[i][j] + dpMin[i - 1][j - 1], map[i][j] + dpMin[i - 1][j]), map[i][j] + dpMin[i - 1][j + 1]);
                } else {
                    dpMax[i][j] = Math.max(map[i][j] + dpMax[i - 1][j - 1], map[i][j] + dpMax[i - 1][j]);
                    dpMin[i][j] = Math.min(map[i][j] + dpMin[i - 1][j - 1], map[i][j] + dpMin[i - 1][j]);
                }
            }
        }

        int max = Math.max(Math.max(dpMax[n][0], dpMax[n][1]), dpMax[n][2]);
        int min = Math.min(Math.min(dpMin[n][0], dpMin[n][1]), dpMin[n][2]);

        System.out.println(max + " " + min);
    }
}
