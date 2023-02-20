package algorithm_study.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정_거리의_도시_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 개수
        int k = Integer.parseInt(st.nextToken()); // 거리 정보
        int x = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        /* 그래프 초기화 */
        ArrayList<ArrayList<Integer>> city = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            city.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            city.get(a).add(b);
        }

        /* 방문 배열 */
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);

        bfs(city, x, visited);

        /* 조건을 만족하는 도시의 번호들만 StringBuilder에 추가 */
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < visited.length; i++) {
            if(visited[i] == k) sb.append(i + "\n");
        }

        /* 조건을 만족하는 도시가 하나도 없다면 -1 출력, 하나라도 있다면 도시 번호 출력 */
        if(sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.print(sb);
        }

    }

    public static void bfs(ArrayList<ArrayList<Integer>> city, int start, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start]++;

        while(!q.isEmpty()) {
            int tmp = q.poll();

            for(int node : city.get(tmp)) {
                /* 방문 배열의 값이 -1일 경우(한 번도 들리지 않았을 경우) */
                if(visited[node] == -1) {
                    visited[node] = visited[tmp] + 1; // 출발점으로부터 해당 도시까지 거리값 갱신
                    q.add(node);
                }
            }
        }
    }
}
