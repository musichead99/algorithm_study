package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_1913 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        br.close();

        int[][] arr = new int[N][N];
        int value = 1;
        int count = 1;

        int x = N/2;
        int y = N/2;
        while(true) {
            for(int i = 0; i < count; i++) {
                arr[x--][y] = value++;
            }

            if(count == N) break;

            for(int i = 0; i < count; i++) {
                arr[x][y++] = value++;
            }
            count++;

            for(int i = 0; i < count; i++) {
                arr[x++][y] = value++;
            }

            for(int i = 0; i < count; i++) {
                arr[x][y--] = value++;
            }
            count++;
        }

        int result_x = -1;
        int result_y = -1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(arr[i][j] + " ");
                if(arr[i][j] == target) {
                    result_x = i + 1;
                    result_y = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(result_x + " " + result_y);
        System.out.println(sb);
    }
}
