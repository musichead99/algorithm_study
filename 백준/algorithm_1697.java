package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algorithm_1697 {

    static class Node {
        int x; // 현재 좌표
        int sec; // 걸린 시간

        public Node(int x, int sec) {
            this.x = x;
            this.sec = sec;
        }
    }

    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(n, k);
    }

    public static void bfs(int start, int end) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        visited[start] = true;

        while(!q.isEmpty()) {
            Node tmp = q.poll();

            /* 수빈이가 동생을 찾았다면 탈출 */
            if(tmp.x == end) {
                System.out.println(tmp.sec);
                break;
            } 

            /* 다음 이동 가능한 좌표들 */
            int[] nx = {tmp.x + 1, tmp.x - 1, tmp.x * 2};
            int nsec = tmp.sec + 1;

            for(int x : nx) {
                /* 0 <= x <= 100000으로 범위를 한정하고 이미 방문한 좌표는 제외한다 */
                if(x >= 0 && x <= 100000 && !visited[x]) {
                    q.add(new Node(x, nsec));
                    visited[x] = true;
                }
            }
        }
    }
}