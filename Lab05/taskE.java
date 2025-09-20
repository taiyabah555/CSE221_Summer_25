import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class taskE {

    static List<List<Integer>> adj;
    static int[] subtreeSize;
    static boolean[] vis;

    static void dfs(int node){
        vis[node] = true;
        subtreeSize[node] = 1; 

        for(int neighbor : adj.get(node)){
            if(!vis[neighbor]){
                dfs(neighbor);
                subtreeSize[node] += subtreeSize[neighbor];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        //List<List<Integer>>
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken()) ;
            int v = Integer.parseInt(st.nextToken()) ;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        subtreeSize = new int[n + 1];
        vis = new boolean[n + 1];

        dfs(r);

        int q = Integer.parseInt(reader.readLine().trim());
        for(int i =0; i<q; i++) {
            int x = Integer.parseInt(reader.readLine().trim());
            System.out.println(subtreeSize[x]);
            
        }

    }
}
