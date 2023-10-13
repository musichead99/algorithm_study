import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_20365 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] works = br.readLine().toCharArray();

        char first = works[0];
        int count = 0;

        for(int i = 0; i < n - 1; i++) {
            if(works[i] != first && works[i + 1] == first) {
                count++;
            }
        }

        if(works[n-1] != first) {
            count++;
        }

        count++;

        System.out.println(count);
    }
} 
