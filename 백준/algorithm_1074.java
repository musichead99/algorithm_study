package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_1074 {

    static int r;
    static int c;
    static int result = 0; // 방문 순서를 저장할 변수

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2, n);

        divideAndConquer(size, 0, 0);

        System.out.println(result);
    }

    public static void divideAndConquer(int size, int x, int y) {
        if(size == 1) {
            return;
        }

        int nextSize = size / 2;

        /* 1사분면 */
        if(c < x + nextSize && r < y + nextSize) {
            divideAndConquer(nextSize, x, y);
        }
        /* 2사분면 */
        else if (c >= x + nextSize && r < y + nextSize) {
            result += size*size / 4;
            divideAndConquer(nextSize, x + nextSize, y);
        }
        /* 3사분면 */
        else if (c < x + nextSize && r >= y + nextSize) {
            result += size*size / 4 * 2;
            divideAndConquer(nextSize, x, y + nextSize);
        }
        /* 4사분면 */
        else if (c >= x + nextSize && r >= y + nextSize) {
            result += size*size / 4 * 3;
            divideAndConquer(nextSize, x + nextSize, y + nextSize);
        }
    }
}
