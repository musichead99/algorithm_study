package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 뱀 {

    /* 방향 정보 */
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        /* 맵 구성을 위해 맵의 크기와 사과의 위치 입력받기 */
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][n + 1];
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
        }

        /* 뱀 회전 정보 입력받기 */
        int l = Integer.parseInt(br.readLine());
        Map<Integer, Character> snakeRotate = new HashMap<>();
        for(int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            char r = st.nextToken().charAt(0);

            snakeRotate.put(t, r);
        }

        /* 초기 설정 */
        List<int[]> snake = new LinkedList<>();
        snake.add(new int[]{1, 1});

        int count = 0;
        int direction = 0;
        int x = 1;
        int y = 1;
        map[x][y] = 2; // 뱀이 있는 위치는 2로 표기

        /* 뱀 게임 시작 */
        while(true) {
            count++;
            int nx = dx[direction] + x;
            int ny = dy[direction] + y;
            /* 게임 종료 조건부터 체크 */
            if(nx <= n && ny <= n && nx > 0 && ny > 0 && map[nx][ny] != 2) {

                if(map[nx][ny] == 1) { // 사과 먹은 경우
                    snake.add(new int[]{nx, ny}); // 뱀 몸통 업데이트
                    map[nx][ny] = 2; // 뱀 위치 기록
                } else { // 아무것도 없는 경우
                    snake.add(new int[]{nx, ny});
                    int[] tmp = snake.remove(0); // 뱀 꼬리 제거
                    map[tmp[0]][tmp[1]] = 0; // 맵에도 기록
                    map[nx][ny] = 2;
                }

                /* 만약 회전할 시간이 되었다면 */
                if(snakeRotate.containsKey(count)) {
                    char nd = snakeRotate.remove(count);

                    if(nd == 'D') {
                        direction = (direction + 1) % 4;
                    } else if (nd == 'L') {
                        direction = (direction - 1) % 4;
                    }

                    if(direction == -1) direction = 3;
                }

                /* 뱀 머리 위치 업데이트 */
                x = nx;
                y = ny;

            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
