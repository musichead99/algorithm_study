package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 666; ; i++) {
            if(Integer.toString(i).contains("666")) {
                count++;
            }
            if(count == n) {
                System.out.println(i);
                break;
            }
        }
    }
}
