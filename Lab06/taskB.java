import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class taskB {
    static List<List<Integer>> adj;
    static boolean[]  vis;
    static int[] color;

    public static int[] bfs(int a){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        vis[a] = true;
        color[a] = 1;
        int countA = 0, countB = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            if(color[node] == 1) countA++;
            else countB++;

            for(int neighbor : adj.get(node)){
                if(!vis[neighbor]){
                    vis[neighbor] = true;
                    color[neighbor] = -color[node];
                    queue.add(neighbor);
                }
                else if(color[neighbor]== color[node]){}
            }
        }
        return new int[] {countA, countB};
    }
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList<>();
        for(int i =0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        color = new int[n+1];
        vis = new boolean [n+1];
        int count =0;

        for (int i=1; i<=n; i++){
            if(!vis[i]){
                int [] loop = bfs(i);
                count += Math.max(loop[0], loop[1]);
            }
        }
        System.out.println(count);
    }
}

