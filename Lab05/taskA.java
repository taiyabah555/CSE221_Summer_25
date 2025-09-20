import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class taskA {
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i=1; i<=n;i++){
            Collections.sort(adj.get(i));
        }

        boolean[] vis = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> trav = new ArrayList<>();

        vis[1] = true;
        queue.add(1);

        while(!queue.isEmpty()){
            int u = queue.poll();
            trav.add(u);

            for(int v : adj.get(u)){
                if(!vis[v]){
                    vis[v] =true;
                    queue.add(v);
                }
            }
        }
        for(int node : trav){
            System.out.print(node + " ");
        }
    }
}
