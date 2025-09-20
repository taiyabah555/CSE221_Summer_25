import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
 
public class taskC {
    static int [] parent, size;
    static List<int[]> edges;
    static List<int[]> mstEdges;
    static List<int[]>[] adj;
    static long mstCost;
 
    public static int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
 
    static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return false;
        if(size[a]<size[b]){
            int temp = a;
            a = b;
            b = temp;
        }
        parent[b] =a;
        size[a]+= size[b];
        return true;
    }
 
    static int dfsMaxEdge(int u, int v, boolean[] visited) {
        if (u == v) return 0;
        visited[u] = true;
        for (int[] e : adj[u]) {
            int nxt = e[0], w = e[1];
            if (!visited[nxt]) {
                int res = dfsMaxEdge(nxt, v, visited);
                if (res != -1) return Math.max(res, w);
            }
        }
        return -1;
    }
 
    public static void main(String [] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
 
        edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new int[]{u, v, w});
        }
 
        parent = new int[n+1];
        size = new int[n+1];
 
        for(int i=1; i<=n; i++){
            parent[i]=i;
            size[i]=1;
        }
 
        Collections.sort(edges, Comparator.comparingInt(a -> a[2]));
        mstEdges = new ArrayList<>();
        mstCost = 0;
        for (int[] e : edges) {
            if (union(e[0], e[1])) {
                mstEdges.add(e);
                mstCost += e[2];
            }
        }
 
        if (mstEdges.size() != n - 1) {
            System.out.println(-1);
            return;
        }
 
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int[] e : mstEdges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
            adj[e[1]].add(new int[]{e[0], e[2]});
        }
 
        long secBest = Long.MAX_VALUE;
 
        for (int[] e : edges) {
            if (mstEdges.contains(e)) continue;
            boolean[] visited = new boolean[n + 1];
            int maxInPath = dfsMaxEdge(e[0], e[1], visited);
            if (maxInPath != -1 && e[2] > maxInPath) {
                long newCost = mstCost - maxInPath + e[2];
                if (newCost > mstCost && newCost < secBest) {
                    secBest = newCost;
                }
            }
        }
        if(secBest == Long.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(secBest);
        }
 
    }
}