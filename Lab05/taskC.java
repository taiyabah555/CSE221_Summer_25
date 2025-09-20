
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

public class taskC {
    static List<List<Integer>> adjList;
    static boolean [] vis;
    static int[] parent;
    static int[] dist;
    //static List<Integer> trav;

    public static void bfs(int s, int d){
        Queue<Integer> queue = new LinkedList<>();
        vis[s] = true;
        dist[s] = 0;
        parent[s] = -1;
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
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer (reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int [] u_list = new int[m];
        int [] v_list = new int[m];

        st = new StringTokenizer (reader.readLine());
        for(int i =0;  i<m; i++){
            u_list[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer (reader.readLine());
        for(int i =0;  i<m; i++){
            v_list[i] = Integer.parseInt(st.nextToken());
        }

        //List<List<Integer>> 
        adjList = new ArrayList<>();
        for(int i =0; i<=n ; i++){
            adjList.add(new ArrayList<>());
        } 
        for (int i = 0; i < m; i++) {
            adjList.get(u_list[i]).add(v_list[i]);
            adjList.get(v_list[i]).add(u_list[i]);
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

        vis = new boolean[n + 1];
        parent = new int[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, -1);

        bfs(s,d);

        if (!vis[d]) {
            System.out.println(-1);
        } else {
            System.out.println(dist[d]);
            List<Integer> path = new ArrayList<>();
            for (int cur = d; cur != -1; cur = parent[cur]) {
                path.add(cur);
            }
            Collections.reverse(path);
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1) System.out.print(" ");
            }
            System.out.println();
        }       
    }
}
