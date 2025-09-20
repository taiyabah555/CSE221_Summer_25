import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class taskB {
    static int [] parent, size;

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
    public static void main(String [] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] edge = new int[m][3];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(reader.readLine());
            edge [i][0] = Integer.parseInt(st.nextToken());
            edge [i][1] = Integer.parseInt(st.nextToken());
            edge [i][2] = Integer.parseInt(st.nextToken());
        }

        parent = new int[n+1];
        size = new int[n+1];

        for(int i=1; i<=n; i++){
            parent[i]=i;
            size[i]=1; 
        }

        long totalCost =0, edgeCount=0;
        Arrays.sort(edge, Comparator.comparingInt(a-> a[2]));
        for(int [] e : edge){
            if (union(e[0],e[1])){
                totalCost += e[2];
                edgeCount++;
                if(edgeCount == n-1) break;
            }
        }
        System.out.println(totalCost);

    } 
}
