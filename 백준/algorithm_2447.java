package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algorithm_2447 {

    static char[][] starMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        starMap = new char[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                starMap[i][j] = ' ';
            }
        }

        drawStars(0, 0, N);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(starMap[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());

        br.close();
    }

    private static void drawStars(int i, int j, int N) {
        if(N == 3) {
            starMap[i][j] = '*';
            starMap[i][j + 1] = '*';
            starMap[i][j + 2] = '*';
            starMap[i + 1][j] = '*';
            starMap[i + 1][j + 2] = '*';
            starMap[i + 2][j] = '*';
            starMap[i + 2][j + 1] = '*';
            starMap[i + 2][j + 2] = '*';
        } else {
            drawStars(i, j, N/3);
            drawStars(i, j + (N / 3), N/3);
            drawStars(i, j + (N / 3) * 2, N/3);
            drawStars(i + (N / 3), j, N/3);
            drawStars(i + (N / 3), j + (N / 3) * 2, N/3);
            drawStars(i + (N / 3) * 2, j, N/3);
            drawStars(i + (N / 3) * 2, j + (N / 3), N/3);
            drawStars(i + (N / 3) * 2, j + (N / 3) * 2, N/3);
        }
    }
}

// public class algorithm_2447 {

//     static StringBuilder sb = new StringBuilder();
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
//         int N = Integer.parseInt(br.readLine());

//         for(int i = 0; i < N; i++) {
//             for(int j = 0; j < N; j++) {
//                 drawStars(i, j, N);
//             }
//             sb.append("\n");
//         }

//         System.out.print(sb.toString());

//         br.close();
//     }

//     private static void drawStars(int x, int y, int N) {
//         if((x / N) % 3 == 1 && (y / N) % 3 == 1) {
//             sb.append(" ");
//         }
//         else
//         {
//             if(N / 3 == 0)
//             sb.append("*");
//             else
//                 drawStars(x,y,N/3);
//         }
//     }
// }