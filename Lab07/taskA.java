import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class taskA {
    static List<List<int[]>> adj;
    public static void main (String [] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st ;
        String [] line1 = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(line1[0]), m = Integer.parseInt(line1[1]), s = Integer.parseInt(line1[2]), d = Integer.parseInt(line1[3]);

        adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        String [] u_list = reader.readLine().trim().split(" ");
        String [] v_list = reader.readLine().trim().split(" ");
        String [] w_list = reader.readLine().trim().split(" ");


        for(int i=0; i<m;  i++){
            int from = Integer.parseInt(u_list[i]);
            int to = Integer.parseInt(v_list[i]);
            int weight = Integer.parseInt(w_list[i]);
            adj.get(from).add(new int[]{to, weight});
        }

        int [] dist = new int [n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s]=0;
        int [] parent = new int [n+1];
        Arrays.fill(parent, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int []{s,0});

        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int u = curr[0];
            int d_u =curr[1];

            if(d_u>dist[u]) continue;

            for(int [] edge : adj.get(u)){
                int v = edge [0];
                int w = edge [1];
                if(dist[v] > dist[u] + w){
                    dist [v] = dist[u] + w;
                    parent[v] = u;
                    pq.add(new int []{v, dist[v]});
                }
            }
        }
        if(dist[d] ==  Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(dist[d]);
            List<Integer> path = new ArrayList<>();
            for(int v =d; v!=-1; v=parent[v]){
                path.add(v);
            }
            Collections.reverse(path);
            for(int node : path){
                System.out.print(node+" ");
            }
            System.out.println();
        }
    }
}
