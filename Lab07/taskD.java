import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class taskD {
    static List<List<int[]>> adj;
    public static void main(String [] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        String [] line1 = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(line1[0]), m = Integer.parseInt(line1[1]), s = Integer.parseInt(line1[2]), d = Integer.parseInt(line1[3]);
        String [] line2 = reader.readLine().trim().split(" ");

        adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w_to = Integer.parseInt(line2[to - 1]);
            adj.get(from).add(new int[]{to, w_to});
        }


        int [] dist = new int [n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s]=Integer.parseInt(line2[s - 1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int []{s,0});

        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int u = curr[0];
            int d_u = curr[1];

            if(d_u > dist[u]) continue;

            for(int [] edge : adj.get(u)){
                int v = edge [0];
                int w = edge [1];
                if(dist[v] > dist[u] + w){
                    dist [v] = dist[u] + w;
                    pq.add(new int []{v, dist[v]});
                }
            }
        }
        if (dist[d] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist[d]);
        }
    }
}
