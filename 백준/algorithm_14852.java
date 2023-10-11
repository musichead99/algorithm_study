import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_14852 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] tiles = new long[n + 1];

        tiles[0] = 1;
        tiles[1] = 2;

        if(n > 1) {
            tiles[2] = 7;
        }

        long tempSum = 20; 

        for(int i = 3; i <= n; i++) {
            tiles[i] = (tempSum + tiles[i - 2]) % 1000000007;
            tempSum = (tempSum + 2 * tiles[i]) % 1000000007;
        }

        System.out.println(tiles[n]);
    }
}