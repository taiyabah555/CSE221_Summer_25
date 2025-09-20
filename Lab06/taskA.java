import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class taskA {

    static List<List<Integer>> adj;
    public static void main(String [] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        int [] inDegree = new int[n+1];
        for(int i =0;  i<=n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<m; i++){
            st = new StringTokenizer (reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 1; i<=n; i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int course = queue.poll();
            result.add(course);

            for(int neighbor : adj.get(course)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    queue.add(neighbor);
                }
            }
        }

        if(result.size()==n){
            for(int course: result){
                System.out.print(course+" ");
            }
        }
        else System.out.println(-1);

    }
}
