package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class algorithm_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        Loop:
        while(t-- > 0) {
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            StringTokenizer st = new StringTokenizer(arr, "[],");

            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }

            /* 함수 실행 */
            boolean reverseFlag = false;
            for(int i = 0; i < func.length(); i++) {

                /* 각 함수에 맞는 작업 수행 */
                if(func.charAt(i) == 'R') {
                    reverseFlag = !reverseFlag; // reverseflag의 상태를 변경
                } else if(func.charAt(i) == 'D') {

                    /* 연산을 실행할 수 없을 땐 error출력 */
                    if(list.isEmpty()) {
                    sb.append("error\n");
                    continue Loop;
                    }

                    /* reverseFlag의 상태에 따라 연산이 실행되는 위치가 달라짐 */
                    if(reverseFlag) {
                        list.remove(list.size() - 1);
                    }
                    else {
                        list.remove(0);
                    }
                }
            }

            /* 함수 결과 출력 준비 */
            sb.append("[");
            
            if(!list.isEmpty()) {
                
                if(reverseFlag) {
                    sb.append(list.get(list.size() - 1));
                    for(int i = list.size() - 2; i > -1; i--) {
                        sb.append("," + list.get(i));
                    }
                } 
                
                else {
                    sb.append(list.get(0));
                    for(int i = 1; i < list.size(); i++) {
                        sb.append("," + list.get(i));
                    }
                }
            }

            sb.append("]\n");
        }

        System.out.println(sb); // 결과 출력
    }
}
