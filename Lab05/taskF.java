
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class taskF {
    static List<List<Integer>> adj;
    static int[] state;
    static boolean hasCycle = false;

    public static void dfs(int node){
        state[node] =1;
        for(int neighbor : adj.get(node)){
            if(state[neighbor] == 0) {
                dfs(neighbor);
            } else if(state[neighbor] == 1) {
                hasCycle = true;
                return;
            }
        }
        state[node]++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i =0; i<m; i++){
            st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
        }
        state = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (state[i] == 0) {
                dfs(i);
                if (hasCycle) break;
            }
        }
        if (hasCycle) {
            System.out.println("YES");
        } 
        else {
            System.out.println("NO");
        }
    }
}
