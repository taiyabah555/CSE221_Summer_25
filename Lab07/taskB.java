import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class taskB {
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

        for(int i=0; i<m;  i++){
            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj.get(from).add(new int[]{to, weight});
        }

        int [] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int []{s,0});

        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int u  = curr[0], d_u = curr[1];
            
            if(d_u>dist[u]) continue;

            for(int [] edge : adj.get(u)){
                int v = edge [0], w = edge [1];
                if(dist[v] > dist[u]+w){
                    dist[v] = dist[u]+w;
                    pq.add(new int []{v, dist[v]});
                }
            }
        }
        
        int[] dist2 = new int [n+1];
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist2[d] =0;
        pq.clear();
        pq.add(new int []{d, 0});
        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int u = curr[0], d_u = curr[1];

            if(d_u> dist2[u]) continue;

            for(int[] edge : adj.get(u)){
                int v = edge[0], w = edge[1];
                if(dist2[v]> dist2[u]+w){
                    dist2[v] = dist2[u]+w;
                    pq.add(new int[]{v, dist2[v]});
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int meet = -1;
        for (int i =1; i<=n; i++){
            if(dist[i]!=Integer.MAX_VALUE && dist2[i]!=Integer.MAX_VALUE){
                int time = Math.max(dist[i], dist2[i]);
                if (time < min || (time == min  && i<meet)){
                    min = time;
                    meet = i;
                }
            }
        }

        if(meet == -1){
            System.out.println(-1);
        }
        else{
            int [] arr = {min, meet};
            for(int node : arr){
                System.out.print(node+ " ");
            }
        }
    }
}
