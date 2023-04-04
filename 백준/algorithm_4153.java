package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algorithm_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] triangle = new int[3];


        while(true) {
            st = new StringTokenizer(br.readLine());

            int count = 0;
            for(int i = 0; i < 3; i++) {
                triangle[i] = Integer.parseInt(st.nextToken());
                if(triangle[i] == 0) count++;
            }
            if(count == 3) break;

            Arrays.sort(triangle);

            if(triangle[0] * triangle[0] + triangle[1] * triangle[1] == triangle[2] * triangle[2]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
