import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algorithm_3078 {

    private static class Friends {
        long[] countings = new long[21];

        public Friends(String[] students, int k) {
            for(int i = 0; i < k + 1; i++) {
                countings[students[i].length()]++;
            }
        }

        public long getFirendsCount(String studentName) {
            return countings[studentName.length()];
        }

        public void removeAndAddNextFriends(String removedStudents, String addedStudent) {
            removeFriends(removedStudents);
            countings[addedStudent.length()]++;
        }

        public void removeFriends(String removedStudent) {
            countings[removedStudent.length()]--;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] students = new String[n];
        long count = 0;

        for(int i = 0; i < n; i++) {
            students[i] = br.readLine();
        }

        Friends friends = new Friends(students, k - 1);

        for(int i = 0; i < n; i++) {
            if(i + k < n) {
                friends.removeAndAddNextFriends(students[i], students[i + k]);
            } else {
                friends.removeFriends(students[i]);
            }

            count += friends.getFirendsCount(students[i]);
        }

        System.out.println(count);
    }
}
