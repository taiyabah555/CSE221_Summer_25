import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class taskC {
    static int n;
    static boolean [][] vis;

    static class Position {
        int x, y, moves;
        Position(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static int bfs(int x1, int y1, int x2, int y2) {
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x1, y1, 0));
        vis[x1][y1] = true;

        while (!queue.isEmpty()) {
            Position curr = queue.poll();
            if (curr.x == x2 && curr.y == y2) {
                return curr.moves;
            }
            for (int i = 0; i < 8; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (isValid(nx, ny) && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    queue.add(new Position(nx, ny, curr.moves+1));
                }
            }
        }
        return -1; 
    }


    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        String [] emni = reader.readLine().trim().split(" ");
        int [] line = new int[4];
        for(int i =0; i<4; i++){
            line[i] = Integer.parseInt(emni[i]);
        }
        vis = new boolean [n][n];
        int result = bfs(line[0]-1, line[1]-1, line[2]-1, line[3]-1);
        System.out.println(result);
    }
}
