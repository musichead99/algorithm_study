package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice4_1 {

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] x = {1, -1, 0, 0};
    public static int[] y = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {\
        /* 입력값 파싱 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        /* 계획서대로 좌표를 조정 */
        Node now = new Node(1,1);
        while(st.hasMoreTokens()) { // StringTokenizer에 남은 토큰이 없을때까지 반복

            char command = st.nextToken().charAt(0);

            int tmp;
            if(command == 'L') {
                tmp = 3;
            } else if(command == 'R') {
                tmp = 2;
            } else if(command == 'U') {
                tmp = 1;
            } else {
                tmp = 0;
            }

            /* 계획서에 따라 이동한 좌표가 맵 밖으로 벗어나지 않으면 반영한다 */
            if(now.x + x[tmp] >= 1 && now.x + x[tmp] <= n && now.y + y[tmp] >= 1 && now.y + y[tmp] <= n) {
                now.x += x[tmp];
                now.y += y[tmp];
            }
        }

        br.close();
        System.out.println(now.x + " " + now.y);
    }
}
