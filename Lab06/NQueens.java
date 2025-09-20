import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens{
    public static void main(String[] args){
        int N = 14; //8,15,N
        NQueensBruteForce(N);
    }
    public static void NQueensBruteForce(int chessBoardSize){
        char[][] board = new char[chessBoardSize][chessBoardSize];
        
        for(int idx = 0; idx < chessBoardSize; idx++){
            Arrays.fill(board[idx],'.');
        }
        List<List<String>> solutionStates = new ArrayList<>();
        
        solve(0, board, solutionStates, chessBoardSize);
        
        printBoard(solutionStates);
    }

    public static boolean isSafe(int row, int column, char[][] board, int cbS){

        for(int c = column; c >= 0; c--){
            if(board[row][c] == 'Q'){
                return false;
            }
        }
        

        for(int r = row, c = column; r >= 0 && c >= 0; r--, c-- ){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        for(int r = row, c = column; r < cbS && c >= 0; r++, c-- ){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        
        return true;
    }
    public static List<String> addSolution(char[][] board){
        List<String> ans = new ArrayList<>();
        for(char[] row: board){
            ans.add(new String(row));
        }
        return ans;
    }
    public static void solve(int col, char[][] board, List<List<String>> solutionStates, int cbS){
        if(col == cbS){
            solutionStates.add(addSolution(board));
            return;
        }	

        for(int row = 0; row < cbS; row++){
            if(isSafe(row, col, board, cbS)){
                board[row][col] = 'Q';
                solve(col+1, board, solutionStates, cbS);
                board[row][col] = '.';
            }
        }
    }
    public static void printBoard(List<List<String>> board){
        int count = 1;
        for(List<String> sol: board){
            System.out.println("Solution: "+count);
            for(String row: sol){
                System.out.println(row);
            }
            count += 1;
        }
    }
}