package algorithm_study.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algorithm_9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean[] visited = new boolean[10000];
            String[] command = new String[10000];
            
            Arrays.fill(command, ""); // 초기화하지 않으면 배열에 null이 들어가기 때문에 bfs에서 연산 시 예외 발생

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bfs(a,b, visited, command);
            System.out.println(command[b]);
        }
    }

    public static void bfs(int start, int end, boolean[] visited, String[] command) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty() && !visited[end]) {
            int node = q.poll();

            int nd = (node * 2) % 10000;
            int ns = node == 0 ? 9999 : node - 1;
            int nl = (node % 1000) * 10 + (node / 1000);
            int nr = (node / 10) + 1000 * (node % 10);

            if(!visited[nd]) {
                visited[nd] = true;
                q.add(nd);
                command[nd] = command[node] + "D";
            } 
            if(!visited[ns]) {
                visited[ns] = true;
                q.add(ns);
                command[ns] = command[node] + "S";
            }
            if(!visited[nl]) {
                visited[nl] = true;
                q.add(nl);
                command[nl] = command[node] + "L";
            }
            if(!visited[nr]) {
                visited[nr] = true;
                q.add(nr);
                command[nr] = command[node] + "R";
            }
        }
    }
}
