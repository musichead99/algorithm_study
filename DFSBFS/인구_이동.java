package algorithm_study.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 인구_이동 {

    static int n;
    static int l;
    static int r;
    static int[][] map;
    static boolean[][] visited;
    static List<Node> united;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /* 인구 이동 시작 */
        int answer = 0;
        while(true) {
            boolean flag = false; // 인구 이동을 체크하는 플래그
            visited = new boolean[n][n]; // 방문 배열
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    /* 모든 국가들을 기준으로 연합을 찾는다 */
                    if(visited[i][j] == false) {
                        int sum = bfs(i, j); // 연합 된 국가들끼리의 인구수 총합
                        /* 연합에 포함된 국가가 1보다 많아야 인구 이동이 일어난다 */
                        if(united.size() > 1) {
                            movePopulation(sum);
                            flag = true; // 인구 이동이 일어남
                        }
                    }
                }
            }
            if(!flag) break; // 더 이상 인구 이동이 일어나지 않으면 종료
            answer++; // 2중 반복문이 완료되면 한 번의 인구이동이 끝난 것이므로 카운트
        }

        System.out.println(answer);

    }

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        united = new ArrayList<>();

        q.add(new Node(x, y));
        united.add(new Node(x, y));
        visited[x][y] = true;

        int sum = map[x][y]; // 연합 인구수의 합을 기록
        while(!q.isEmpty()) {
            Node tmp = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                /* 해당 좌표가 맵을 벗어나지 않는다면 */
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    int diff = Math.abs(map[nx][ny] - map[tmp.x][tmp.y]);
                    /* 해당 좌표의 국가가 국경선을 열 조건을 만족한다면 */
                    if(diff >= l && diff <= r) {
                        q.add(new Node(nx, ny));
                        visited[nx][ny] = true; // 방문표시
                        united.add(new Node(nx, ny)); // 연합에 추가
                        sum += map[nx][ny];
                    }
                }
            }
        }

        return sum;
    }

    /* 국경선이 열린 국가들끼리 인구 이동을 담당하는 메소드 */
    public static void movePopulation(int sum) {
        int avg = sum / united.size();
        for(Node node : united) {
            map[node.x][node.y] = avg;
        }
    } 
}
