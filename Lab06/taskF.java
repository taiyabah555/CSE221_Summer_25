import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class taskF {
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String [] emni = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(emni[0]);
        int m = Integer.parseInt(emni[1]);
        int s = Integer.parseInt(emni[2]);
        int q = Integer.parseInt(emni[3]);

        List<List<Integer>> adj  = new ArrayList<>();
        for(int i =0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0; i<m; i++){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        int [] dist = new int[n+1];
        Arrays.fill(dist, -1);
        
        String []  source = reader.readLine().split(" ");
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i<s; i++){
            int src = Integer.parseInt(source[i]);
            dist[src] = 0;
            queue.add(src);
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbor : adj.get(node)){
                if(dist[neighbor]==-1){
                    dist[neighbor] = dist[node]+1;
                    queue.add(neighbor);
                }
            }
        }
        String[] destination = reader.readLine().trim().split(" ");
        StringBuilder result = new StringBuilder();
        for(int i =0; i<q; i++){
            int dest = Integer.parseInt(destination[i]);
            result.append(dist[dest]).append(" ");
        }
        System.out.println(result.toString().trim());
    }
}
