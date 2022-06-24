package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임_개발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /* N, M, character, map 정보 입력받기 */
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] character = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /* 맵의 북쪽과 서쪽의 방향 잘 확인하기 */
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] check = new int[N][M];
        int count = 0;
        int turnTime = 0;
        while(true) {
            character = turnLeft(character);

            /* 캐릭터 이동 */
            int nx = character[0] + dx[character[2]];
            int ny = character[1] + dy[character[2]];
            if(map[nx][ny] == 0 && check[nx][ny] == 0) {
                character[0] = nx;
                character[1] = ny;
                count++;
                turnTime = 0;
                check[nx][ny] = 1;
            } else {
                turnTime++;

                /* 4방향 모두 바다거나 지나온 길일 경우 뒤로 이동 */
                if(turnTime == 4) {
                    nx = character[0] - dx[character[2]];
                    ny = character[1] - dy[character[2]];

                    /* 만약 뒤가 바다라면 시뮬레이션 종료 */
                    if(map[nx][ny] == 1) {
                        break;
                    } else {
                        character[0] = nx;
                        character[1] = ny;
                    }
                    turnTime = 0;
                }
            }
        }
        System.out.println(count);
    }

    /* 왼쪽으로 방향을 전환하는 함수 */
    private static int[] turnLeft(int[] character) {
        character[2] = (character[2] + 1) % 4;
        return character;
    }
}
