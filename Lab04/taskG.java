import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class taskG {
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int dx[] = {-1, -2, -2, -1, 1, 2, 2, 1};
        int []dy = {-2, -1, 1, 2, -2, -1, 1, 2};
        
        Set<String> knightPos = new HashSet<>();
        List<int[]> knights = new ArrayList<>();

        for(int i =0; i<k; i++){
            String [] line = reader.readLine().trim().split(" ");
            knights.add(new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])});
            knightPos.add(line[0] + "," + line[1]);
        }

        for(int[] knight : knights) {
            int x = knight[0];
            int y = knight[1];

            for (int j = 0; j < 8; j++) {
                int new_x = x + dx[j];
                int new_y = y + dy[j];

                if (new_x >= 1 && new_x <= n && new_y >= 1 && new_y <= m) {
                    String pos = new_x + "," + new_y;
                    if (knightPos.contains(pos)) {
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }
        System.out.println("NO");
        
    }
}
