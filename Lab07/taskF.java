import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class taskF {
    static List<List<int[]>> adj;
    public static void main(String [] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        String [] line1 = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(line1[0]), m = Integer.parseInt(line1[1]), s = Integer.parseInt(line1[2]), d = Integer.parseInt(line1[3]);

        adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj.get(from).add(new int[]{to, weight});
            adj.get(to).add(new int[]{from, weight});
        }

        int [][] dist = new int[n+1][2];
        for(int i=0; i<=n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        dist[s][0] = 0;
        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a-> a[1]));
        pq.add(new int[]{s, 0});

        int[] count = new int[n+1];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0], d_u = curr[1];
            if(count[u]>= 2) continue;
            count[u]++;

            for(int [] edge : adj.get(u)){
                int v = edge[0], w = edge[1];
                int newDist = d_u + w;

                if (newDist< dist[v][0]){
                    dist[v][1] = dist[v][0];
                    dist[v][0] = newDist;
                    pq.add(new int[]{v, newDist});
                }
                else if(newDist> dist[v][0] && newDist<dist[v][1]){
                    dist[v][1] = newDist;
                    pq.add(new int[]{v, newDist});
                }
            }
        }
        if (dist[d][1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist[d][1]);
        }
    }
}
