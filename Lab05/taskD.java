import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class taskD {

    static List<List<Integer>> adjList;
    static boolean [] vis;
    static int[] parent;
    static int[] dist;
    //static List<Integer> trav;

    public static void bfs(int s){
        Arrays.fill(vis, false);
        Arrays.fill(parent, -1);
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        vis[s] = true;
        dist[s] = 0;
        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adjList.get(u)) {
                if (!vis[v]) {
                    vis[v] = true;
                    dist[v] = dist[u] + 1;
                    parent[v] = u;
                    queue.add(v);
                }
            }
        }

    }

    public static List<Integer> reconstructPath(int target) {
        List<Integer> path = new ArrayList<>();
        while (target != -1) {
            path.add(target);
            target = parent[target];
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String [] args)throws IOException{
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
    
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //List<List<Integer>> 
        adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i<m;i++){
            st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList.get(u).add(v);        
        }
        for(List<Integer> inner : adjList){
            Collections.sort(inner);
        }
        // for(int i =1; i<=n; i++){
        //     System.out.print(i + ":(");
        //     for( int edge : adjList.get(i)){
        //         System.out.print(" "+edge);
        //     }
        //     System.out.print(") ");
        // }

        vis= new boolean[n + 1];
        parent = new int[n + 1];
        dist = new int[n + 1];
        
        bfs(s);
        if(!vis[k]){
            System.out.println(-1);
            return;
        }

        List<Integer> path1 = reconstructPath(k);

        bfs(k);
        if(!vis[d]){
            System.out.println(-1);
            return;
        }

        List<Integer> path2 = reconstructPath(d);

        path1.remove(path1.size() - 1); 
        path1.addAll(path2); 

        System.out.println(path1.size()-1);
        for(int node : path1){
            System.out.print(node + " ");
        }

    }
}
