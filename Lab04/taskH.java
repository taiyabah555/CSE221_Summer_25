import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class taskH {

    public static int gcd(int a, int b){
        while (b!=0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j && gcd(i, j) == 1) {
                    graph[i].add(j);
                }
            }
            Collections.sort(graph[i]); 
        }

        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            String[] query = reader.readLine().split(" ");
            int X = Integer.parseInt(query[0]);
            int K = Integer.parseInt(query[1]);

            if (K <= graph[X].size()) {
                sb.append(graph[X].get(K - 1)).append("\n");
            } else {
                sb.append("-1\n");
            }
        }
        System.out.print(sb);
    }
}
