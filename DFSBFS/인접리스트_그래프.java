package algorithm_study.DFSBFS;

import java.util.ArrayList;
import java.util.List;

public class 인접리스트_그래프 {
    private static class Node {
        int end;
        int cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "(" + end + ", " + cost + ")";
        }
    }
    public static void main(String[] args) {
        List<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

        for(int i = 0; i < 3; i++) {
            graph.add(new ArrayList<Node>());
        }

        graph.get(0).add(new Node(1, 7));
        graph.get(0).add(new Node(2, 5));

        graph.get(1).add(new Node(0, 7));

        graph.get(2).add(new Node(0, 5));

        System.out.println(graph.toString());

    }
}
