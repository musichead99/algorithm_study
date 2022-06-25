package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 문자열_재정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();

        /* 알파벳 대문자와 수의 합을 입력받을 변수 선언 */
        char[] alphabetString = new char[10001];
        int numSum = 0;

        /* 입력받은 문장을 처음부터 순회 */
        for(int i = 0; i < sentence.length(); i++) {
            char temp = sentence.charAt(i);

            if(temp >= 'A' && temp <= 'Z') {
                alphabetString[i] = temp;
            } else {
                numSum += Character.getNumericValue(temp);
            }
        }
        Arrays.sort(alphabetString); // 알파벳 정렬
        String wholeString = new String(alphabetString) + Integer.toString(numSum);
        System.out.println(wholeString);
    }
}
