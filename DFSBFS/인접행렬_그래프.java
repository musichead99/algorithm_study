package algorithm_study.DFSBFS;

import java.util.Arrays;

public class 인접행렬_그래프 {
    public static void main(String[] args) {
        final int INF = 999999999;

        int[][] graph = {{0, 7, 5}, {7, 0, INF}, {5, INF, 0}};

        System.out.println(Arrays.deepToString(graph));
    }
}
