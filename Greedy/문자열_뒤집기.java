package algorithm_study.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] count = new int[2];

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < S.length(); j++) {
                if(S.charAt(j) != Character.forDigit(i, 10)) {
                    if(j == S.length() - 1 || S.charAt(j) != S.charAt(j+1)) {
                        count[i]++;
                    }
                }
            }
        }
        System.out.println(Math.min(count[0], count[1]));
    }
}
