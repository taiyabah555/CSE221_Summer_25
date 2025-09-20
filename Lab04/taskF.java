
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class taskF {
    public static void main(String [] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int size = Integer.parseInt(st.nextToken());
        
        String[] line = reader.readLine().trim().split(" ");
        
        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);
        
        int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int []dy = {-1, 0, 1, -1, 1, 0, -1, 1};

        ArrayList<int[]> moves = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];

            if (new_x >= 1 && new_x <= size && new_y >= 1 && new_y <= size) {
                moves.add(new int[]{new_x, new_y});
            }
        }
        for (int i = 0; i < moves.size() - 1; i++) {
            for (int j = i + 1; j < moves.size(); j++) {
            int[] a = moves.get(i);
            int[] b = moves.get(j);
                if (a[0] > b[0] || (a[0] == b[0] && a[1] > b[1])) {
                    moves.set(i, b);
                    moves.set(j, a);
                }
            }
        }

        System.out.println(moves.size());
        for (int[] move : moves) {
            System.out.println(move[0] + " " + move[1]);
        }
    }
}
