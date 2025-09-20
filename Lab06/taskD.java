import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class taskD {
    static List<List<Integer>> adj;
    static int n;

    static int[] bfs(int start) {
    boolean[] visited = new boolean[n + 1];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{start, 0});
    visited[start] = true;

    int[] farthest = new int[]{start, 0}; 

    while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        int node = curr[0], dist = curr[1];
        if (dist > farthest[1]) {
            farthest[0] = node;
            farthest[1] = dist;
        }
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.add(new int[]{neighbor, dist + 1});
            }
        }
    }

    return farthest;
}
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList<>();
        for(int i =0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] first = bfs(1);
        int[] second = bfs(first[0]);

        System.out.println(second[1]);
        System.out.println(first[0] + " " + second[0]);

    }
}
