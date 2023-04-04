package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class algorithm_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        int start = 1; // 1~n까지의 수 중 1부터 시작
        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine()); // 스택을 이용해 출력해야 할 수

            /* 만약 start가 tmp보다 작다면 start값 부터 순차적으로 tmp값 까지 스택에 넣는다 */
            if(start <= tmp) {
                for(int j = start; j <= tmp; j++) {
                    s.push(j);
                    sb.append("+\n");
                }
                start = tmp + 1;
            }
            
            /* 스택의 맨 위 원소가 tmp와 같지 않다면 해당 수열을 만들 수 없기 때문에 NO를 출력하고 종료 */
            if(tmp != s.peek()) {
                System.out.println("NO");
                return;
            }

            s.pop();
            sb.append("-\n");
        }

        System.out.println(sb);

    }
}