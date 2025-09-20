import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class taskD {
    public static void main(String [] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] from = new int[m];
        int [] to = new int[m];
        String [] parts1 = reader.readLine().trim().split(" ");
        String [] parts2 = reader.readLine().trim().split(" ");

        for(int i = 0; i<m; i++){
            from[i] = Integer.parseInt(parts1[i]);
            to[i] = Integer.parseInt(parts2[i]); 
        } 

        int[] degree = new int[n+1];
        for (int i = 0; i<m; i++) {
            degree[from[i]]++;
            degree[to[i]]++;
        }

        int oddCount = 0;
        for (int i = 1; i<=n; i++) {
            if (degree[i]%2 == 1) {
                oddCount++;
            }
        }

        if (oddCount == 0 || oddCount == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
