import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class taskE {
    static List<List<int[]>> adj;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] u = new int[m];
        int[] v = new int[m];
        int[] w = new int[m];

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) u[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) v[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) w[i] = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            adj.get(u[i]).add(new int[]{v[i], w[i]});
        }

        int[][] dist = new int[n + 1][2]; 
        for (int i = 0; i <= n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{1, 0, -1}); 
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int uNode = curr[0], d_u = curr[1], lastParity = curr[2];

            for (int[] edge : adj.get(uNode)) {
                int vNode = edge[0], w2 = edge[1];
                int currParity = w2 % 2;

                if (lastParity != -1 && currParity == lastParity) continue;

                if (dist[vNode][currParity] > d_u + w2) {
                    dist[vNode][currParity] = d_u + w2;
                    pq.add(new int[]{vNode, dist[vNode][currParity], currParity});
                }
            }
        }

        int ans = Math.min(dist[n][0], dist[n][1]);

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }
    }
}