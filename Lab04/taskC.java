import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class taskC {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());

        int [][] arr = new int [n][n];

        for(int i = 0; i < n; i++) {

            String[] parts = reader.readLine().trim().split(" ");
            int k = Integer.parseInt(parts[0]);
            for (int j = 1; j <= k; j++) {
                int to = Integer.parseInt(parts[j]);
                arr[i][to] = 1;
            }            

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}
