import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class taskA {
    public static void main(String [] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        int [][] arr = new int [n][n];

        for(int i = 1; i <= m; i++) {

            // int [] loc = new int [Integer.parseInt(reader.readLine().trim())];
            // String[] parts = reader.readLine().trim().split(" ");
            // for(int j = 0; j < loc.length; j++) {
            //     loc[j] = Integer.parseInt(parts[j]);
            // }

            // arr[loc[0]-1][loc[1]-1] = loc[2];
            String[] parts = reader.readLine().trim().split(" ");
            int from = Integer.parseInt(parts[0]) - 1;
            int to = Integer.parseInt(parts[1]) - 1;
            int weight = Integer.parseInt(parts[2]);
            arr[from][to] = weight;

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
