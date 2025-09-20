import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class taskG {
    static int a, b;
    static char [][] grid;
    static boolean [][] vis;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    public static int dfs(int x, int y){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        vis[x][y] = true;
        int count = 0;        

        while(!stack.isEmpty()){
            int[] curr = stack.pop();
            int curr_x = curr[0], curr_y = curr[1];

            if(grid[curr_x][curr_y] == 'D') {
                count++;
            }

            for(int dir=0; dir < 4; dir++){
                int new_x = curr_x + dx[dir];
                int new_y = curr_y + dy[dir];

                if(new_x>=0 && new_x<a && new_y>=0 && new_y<b 
                   && !vis[new_x][new_y] && grid[new_x][new_y] != '#'){
                    vis[new_x][new_y] = true;
                    stack.push(new int[]{new_x, new_y});
                }
            }
        }
        return count;
    }
    
    public static void main(String [] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        grid = new char[a][b];
        vis = new boolean[a][b];

        for(int i = 0; i < a; i++){
            grid[i] = reader.readLine().toCharArray();
        }

        int maxDiamonds = 0;
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                if(!vis[i][j] && grid[i][j] != '#'){
                    maxDiamonds = Math.max(maxDiamonds, dfs(i,j));
                }
            }
        }
        System.out.println(maxDiamonds);
    }
}

