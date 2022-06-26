package algorithm_study.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 성적이_낮은_순서 {

    static class student {
        String name;
        int score;

        student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        student[] students = new student[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            students[i] = new student(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        /* 람다 표현식으로 comparator 인터페이스 구현 */
        Arrays.sort(students, (v1, v2) -> v1.score - v2.score);

        for(int i = 0; i < N; i++) {
            System.out.print(students[i].name + " ");
        }
    }
}
