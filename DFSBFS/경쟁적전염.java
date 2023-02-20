package algorithm_study.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Virus implements Comparable<Virus>{
    int x;
    int y;
    int num;

    public Virus(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }

    @Override
    public int compareTo(Virus o) {
        return this.num - o.num;
    }
}

public class 경쟁적전염 {

    static int n;
    static int k;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        /* s초 동안 전염 시뮬레이션 */
        for(int i = 0; i < s; i++) {
            bfs();

            // 이미 해당 좌표에 바이러스가 심어졌다면 무의미한 반복을 멈추고 탈출
            if(map[x][y] != 0) break; 
        }

        System.out.println(map[x][y]);
    }

    public static void bfs() {
        /* 바이러스는 번호 순서대로 증식하기 때문에 우선순위큐를 사용해서 맞추어 준다 */
        PriorityQueue<Virus> pq = new PriorityQueue<>();

        /* 현 시점 시험관에 존재하는 모든 바이러스의 좌표를 pq에 넣는다 */
        for(int j = 1; j <= n; j++) {
            for(int l = 1; l <= n; l++) {
                if(map[j][l] != 0) {
                    pq.add(new Virus(j, l, map[j][l]));
                }
            }
        }

        /* 1초 동안만 시뮬레이션 하는 것이므로 조건을 만족한다고 해서 노드를 큐에 추가하지는 않음 */
        while(!pq.isEmpty()) {
            Virus tmp = pq.poll();

            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx <= 0 || ny <= 0 || nx > n || ny > n) continue;

                if(map[nx][ny] != 0) continue;
                
                map[nx][ny] = tmp.num;
            }
        }
    }
}