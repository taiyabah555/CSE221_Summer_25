import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class taskB {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        int [] from = new int [m];
        String[] parts = reader.readLine().trim().split(" ");
        int [] to = new int [m];
        String[] parts2 = reader.readLine().trim().split(" ");
        int [] weight = new int [m];
        String[] parts3 = reader.readLine().trim().split(" ");

        for(int j = 0; j < m; j++) {
            from[j] = Integer.parseInt(parts[j]);
            to[j] = Integer.parseInt(parts2[j]);
            weight[j] = Integer.parseInt(parts3[j]);
        }

        List<List<String>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adjList.get(from[i]).add("(" + to[i] + "," + weight[i] + ")");
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(i + ":");
            for (String edge : adjList.get(i)) {
                System.out.print(" " + edge);
            }
            System.out.println();
        }

    }
}
