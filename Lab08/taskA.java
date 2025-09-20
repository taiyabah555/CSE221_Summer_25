
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class taskA {
    static int [] parent, size;

    static int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA!=rootB){
            if(size[rootA]<size[rootB]){
                parent[rootA] = rootB;
                size[rootB]+=size[rootA];
            }
            else{
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
        }
    }

    public static void main(String [] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        size = new int[n+1];

        for(int i=1; i<=n; i++){
            parent[i]=i;
            size[i]=1;
        }

        while(k>0){
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
            System.out.println(size[find(a)]);
            k--;
        }
    }
}
