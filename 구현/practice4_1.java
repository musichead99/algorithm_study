package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice4_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String moveType = br.readLine();
        StringTokenizer st = new StringTokenizer(moveType);
        int[] coordinate = {1, 1};

        while(st.countTokens() != 0) {
            int[] nextcoord = new int[2];
            char move = st.nextToken().charAt(0);

            if(move == 'L') {
                nextcoord[0] = coordinate[0];
                nextcoord[1] = coordinate[1] - 1;
            } else if (move == 'R') {
                nextcoord[0] = coordinate[0];
                nextcoord[1] = coordinate[1] + 1;
            } else if (move == 'U') {
                nextcoord[0] = coordinate[0] - 1;
                nextcoord[1] = coordinate[1];
            } else if (move == 'D') {
                nextcoord[0] = coordinate[0] + 1;
                nextcoord[1] = coordinate[1];
            }

            if(nextcoord[0] <= 0 || nextcoord[0] > N || nextcoord[1] <= 0 || nextcoord[1] > N) {
                continue;
            } else {
                coordinate = nextcoord;
            }
        }

        System.out.println(coordinate[0] + " " + coordinate[1]);
        br.close();
    }
}
