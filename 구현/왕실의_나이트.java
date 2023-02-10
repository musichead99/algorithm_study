package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 왕실의_나이트 {

    static int[] x = {2, 2, -2, -2, 1, -1, 1, -1};
    static int[] y = {1, -1, 1, -1, 2, 2, -2, -2};
    public static void main(String[] args) throws IOException {
        /* 나이트의 좌표 읽어오기 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String coordinate = br.readLine();

        /* 나이트의 좌표값 정수값으로 파싱 */
        int knightX = coordinate.charAt(0) - 96;
        int knightY = Character.getNumericValue(coordinate.charAt(1));

        /* 나이트가 움직일 수 있는 모든 경우의 수를 검사하여 맵을 벗어나는지 확인 */
        int count = 0;
        for(int i = 0; i < 8; i++) {
            if(knightX + x[i] >= 1 && knightX + x[i] <= 8 && knightY + y[i] >= 1 && knightY + y[i] <= 8) {
                count++;
            }
        }

        System.out.println(count);
        br.close();
    }
}
