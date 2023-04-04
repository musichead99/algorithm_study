package algorithm_study.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class algorithm_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            TreeMap<Integer, Integer> pq = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            while(k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char inst = st.nextToken().charAt(0);
                Integer n = Integer.parseInt(st.nextToken());

                if(inst == 'I') {
                    // 키값 n이 없으면 value값을 1로 해서 넣는다., 있다면 이미 있는 value값에 1을 더한다.
                    pq.put(n, pq.getOrDefault(n, 0) + 1);
                } else {
                    if(!(pq.size() == 0)) {
                        if(n == 1) {
                            int tmpKey = pq.lastKey();
                            // 해당 키 값을 제거할 때 value의 값을 1 뺀다. 만약 반환값이 1이라면 현재 값은 0이 되었기 때문에 큐에서 제거한다.
                            if (pq.put(tmpKey, pq.get(tmpKey) - 1) == 1)
                                pq.remove(tmpKey);
                        } else {
                            int tmpKey = pq.firstKey();
                            if (pq.put(tmpKey, pq.get(tmpKey) - 1) == 1)
                                pq.remove(tmpKey);
                        }

                    }
                }
            }
            
            if(!(pq.size() == 0)) {
                int min = pq.firstKey();
                int max = pq.lastKey();
                System.out.println(max + " " + min);
            } else {
                System.out.println("EMPTY");
            }
        }
    }
}
