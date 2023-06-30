import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_11403 {

    private static final int INF = 100000000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {   
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) {
                    map[i][j] = INF;
                }
            }
        }

        for(int i = 0; i < n; i++) { // 중간에 거쳐갈 노드가 제일 밖에 있어야 함
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {   
                if(map[i][j] == INF) {
                    map[i][j] = 0;
                } 

                if(map[i][j] > 0) {
                    map[i][j] = 1;
                }

                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
