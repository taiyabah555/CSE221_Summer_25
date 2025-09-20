import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class taskB {

    static List<List<Integer>> adj;
    static boolean [] vis;
    static List<Integer> trav;

    public static void dfs(int u){
        vis[u] = true;
        trav.add(u);
        for(int v : adj.get(u)){
            if(!vis[v]){
                dfs(v);
            }
        }
    }
    public static void main(String [] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] u_list = new int[m];
        int [] v_list = new int[m];
        st = new StringTokenizer (reader.readLine());
        for(int i = 0; i<m; i++){
            u_list[i] =Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer (reader.readLine());
        for(int i = 0; i<m; i++){
            v_list[i] =Integer.parseInt(st.nextToken());
        }

        adj = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0; i<m; i++){
            int u = u_list[i];
            int v= v_list[i];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        vis = new boolean[n+1];
        trav = new ArrayList<>();

        dfs(1);
        for(int node : trav){
            System.out.print(node + " ");
        }
    }
    
}
