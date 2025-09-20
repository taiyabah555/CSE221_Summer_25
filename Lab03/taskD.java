import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class taskD {
    static final int MOD = 1000000007;

    static void multiply(int[][] A, int[][] B, int[][] res) {
        long a00 = (long) A[0][0] * B[0][0] + (long) A[0][1] * B[1][0];
        long a01 = (long) A[0][0] * B[0][1] + (long) A[0][1] * B[1][1];
        long a10 = (long) A[1][0] * B[0][0] + (long) A[1][1] * B[1][0];
        long a11 = (long) A[1][0] * B[0][1] + (long) A[1][1] * B[1][1];

        res[0][0] = (int) (a00 % MOD);
        res[0][1] = (int) (a01 % MOD);
        res[1][0] = (int) (a10 % MOD);
        res[1][1] = (int) (a11 % MOD);
    }

    static int[][] matrixPow(int[][] A, long exp) {
        int[][] res = { {1, 0}, {0, 1} };  //Identity matrix
        int[][] temp = new int[2][2];

        while (exp > 0) {
            if ((exp & 1) == 1) {
                multiply(res, A, temp);
                copy(temp, res);
            }
            multiply(A, A, temp);
            copy(temp, A);
            exp >>= 1;
        }

        return res;
    }

    static void copy(int[][] src, int[][] dest) {
        dest[0][0] = src[0][0]; dest[0][1] = src[0][1];
        dest[1][0] = src[1][0]; dest[1][1] = src[1][1];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int[][] A = new int[2][2];
            A[0][0] = Integer.parseInt(st.nextToken());
            A[0][1] = Integer.parseInt(st.nextToken());
            A[1][0] = Integer.parseInt(st.nextToken());
            A[1][1] = Integer.parseInt(st.nextToken());

            long x = Long.parseLong(reader.readLine());
            int[][] AX = matrixPow(A, x);

            System.out.println(AX[0][0] + " " + AX[0][1]);
            System.out.println(AX[1][0] + " " + AX[1][1]);
        }
    }
}
