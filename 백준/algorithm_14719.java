import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] map = new int[h][w + 1];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < w + 1; i++) {
            int temp = Integer.parseInt(st.nextToken());
            
            if(temp == 0) {
                continue;
            }

            for(int j = h - temp; j < h; j++) {
                map[j][i] = 1;
            }
        }
        
        for(int i = 0; i < h; i++) {
            int count = 0;
            int highBlock = 0;
            for(int j = 1; j < w + 1; j++) {
                if(map[i][j] != 1) {
                    continue;
                }

                if(highBlock == 0) {
                    highBlock = j;
                    continue;
                }

                count += (j - highBlock - 1);
                highBlock = j;
            }
            answer += count;
        }

        System.out.println(answer);
    }
}
