package algorithm_study.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 국영수 {

    static class Student implements Comparable<Student>{
        String name;
        int koreanScore;
        int englishScore;
        int mathScore;
    
        public Student(String name, int koreanScore, int englishScore, int mathScore) {
            this.name = name;
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }
    
        @Override
        public int compareTo(Student o) {
            if(this.koreanScore != o.koreanScore) { // 국어 점수는 다르다면 감소하는 순서로 정렬
                return o.koreanScore - this.koreanScore;
            } 
            
            if(this.englishScore != o.englishScore) { // 영어 점수는 다르다면 증가하는 순서로 정렬
                return this.englishScore - o.englishScore;
            } 
    
            if(this.mathScore != o.mathScore) { // 수학 점수는 다르다면 감소하는 순서로 정렬 
                return o.mathScore - this.mathScore;
            }
    
            return this.name.compareTo(o.name); // 이름은 사전 순으로 증가하는 순서로
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Student[] students = new Student[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int koreanScore = Integer.parseInt(st.nextToken());
            int englishScore = Integer.parseInt(st.nextToken());
            int mathScore = Integer.parseInt(st.nextToken());

            students[i] = new Student(name, koreanScore, englishScore, mathScore);
        }

        Arrays.sort(students); // 정렬

        for(int i = 0; i < n; i++) {
            System.out.println(students[i].name);
        }
    }
}
