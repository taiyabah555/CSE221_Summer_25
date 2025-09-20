import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class taskC {
    static List<List<int[]>> adj;

    public static void main(String [] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

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
            adj.get(to).add(new int[]{from, weight});
        }

        int [] dist = new int [n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1]=0;
        // int [] parent = new int [n+1];
        // Arrays.fill(parent, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int []{1,0});

        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int u = curr[0];
            int Dan =curr[1];

            if(Dan>dist[u]) continue;

            for(int [] edge : adj.get(u)){
                int v = edge [0];
                int w = edge [1];
                int newDan = Math.max(Dan, w);
                if(dist[v] > newDan){
                    dist [v] = newDan;
                    pq.add(new int []{v, newDan});
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(dist[i]== Integer.MAX_VALUE){
                System.out.print(-1+" ");
            }
            else if(i+1>n) System.out.print(dist[i]);
            else System.out.print(dist[i]+" ");
        }
            System.out.println();
    }
}
