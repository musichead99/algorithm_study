package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 왕실의_나이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String coordString = br.readLine();

        /* 입력받은 문자를 파싱해서 좌표값으로 변경 */
        int[] coord = new int[2];
        coord[0] = coordString.charAt(0) - 'a'; // 입력받은 소문자 아스키코드값에서 'a'를 빼면 좌표값을 얻을 수 있다.
        coord[1] = Character.getNumericValue(coordString.charAt(1)) - 1; // char형의 숫자에서 int형의 값으로 변경하는 코드
        
        /* knight가 이동할 수 있는 방법을 steps 배열에 모아 둠 */
        int[][] steps = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};

        /* knight가 이동할 수 있는 경우의 수 계산 */
        int count = 0;
        int[] temp = new int[2];
        for(int[] step : steps) {
            temp[0] = coord[0] + step[0];
            temp[1] = coord[1] + step[1];

            if(temp[0] < 0 || temp[1] < 0 || temp[0] > 7 || temp[1] > 7) {
                continue;
            }
            count++;
        }

        System.out.println(count);
    }
}
