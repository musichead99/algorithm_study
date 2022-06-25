package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 럭키_스트레이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String score = br.readLine();
        String firstHalf = score.substring(0, score.length()/2);
        String secondHalf = score.substring(score.length()/2);

        int firstSum = 0;
        int secondSum = 0;

        for(int i = 0; i < firstHalf.length(); i++) {
            firstSum += Character.getNumericValue(firstHalf.charAt(i));
            secondSum += Character.getNumericValue(secondHalf.charAt(i));
        }

        if(firstSum == secondSum) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}
