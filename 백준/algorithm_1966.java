package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class algorithm_1966 {

    public static class Node {
        int priority;
        int index;

        public Node(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Node> q = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < num; i++) {
            q.clear(); // 큐 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int priority = Integer.parseInt(st.nextToken());
                q.add(new Node(priority, j));
            }

            int count = 0; // 몇 번째로 출력되는지 계산하기 위한 카운터 변수

            /* 한 테스트케이스에 대한 반복문 시작 */
            while(!q.isEmpty()) {
                Node tmp = q.pop();

                int flag = 0; // 방금 큐에서 뽑아낸 노드(tmp)보다 우선순위가 높은 노드가 있는지를 체크하기 위한 플래그
                for(Node node : q) {
                    if(node.priority > tmp.priority) {
                        flag = 1; // 우선순위가 더 큰 노드가 있다면 플래그 설정
                    }
                }

                if(flag == 0) { // tmp보다 우선순위가 높은 노드가 없다면 문서를 출력하고 개수 갱신
                    count++;
                    if(tmp.index == m) { // tmp가 순서를 알고 싶던 문서를 가리키는 노드였다면 반복문 종료
                        break;
                    }
                } else {
                    q.add(tmp); // tmp보다 우선순위가 높은 노드가 있다면 다시 큐의 맨 뒤에 tmp를 삽입
                }
            }
            System.out.println(count);
        }
    }
}
