
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class taskE {
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int from[] = new int[m], to[] = new int [m];
        String [] parts1 = reader.readLine().trim().split(" ");
        String [] parts2 = reader.readLine().trim().split(" ");

        for(int i = 0; i<m; i++){
            from[i] = Integer.parseInt(parts1[i]);
            to[i] = Integer.parseInt(parts2[i]); 
        } 

        int[] in_degree = new int[n+1], out_degree = new int[n+1];
        StringBuilder res = new StringBuilder();

        for(int i =0; i<m; i++){
            out_degree[from[i]]++;
            in_degree[to[i]]++;
        }

        for(int i = 1; i<=n; i++){
            res.append(in_degree[i] - out_degree[i]).append(' ');
        }
        System.out.println(res.toString().trim());

    }
    
}
