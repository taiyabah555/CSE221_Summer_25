import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class taskD_2 {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int[][] A = new int[2][2];
            A[0][0] = Integer.parseInt(st.nextToken());
            A[0][1] = Integer.parseInt(st.nextToken());
            A[1][0] = Integer.parseInt(st.nextToken());
            A[1][1] = Integer.parseInt(st.nextToken());

            long x = Long.parseLong(reader.readLine());

            int[][] res = { {1, 0}, {0, 1} };
            int[][] temp = new int[2][2];

            while (x > 0) {
                if ((x & 1) == 1) {

                    temp[0][0] = (int) (((long) res[0][0] * A[0][0] + (long) res[0][1] * A[1][0]) % MOD);
                    temp[0][1] = (int) (((long) res[0][0] * A[0][1] + (long) res[0][1] * A[1][1]) % MOD);
                    temp[1][0] = (int) (((long) res[1][0] * A[0][0] + (long) res[1][1] * A[1][0]) % MOD);
                    temp[1][1] = (int) (((long) res[1][0] * A[0][1] + (long) res[1][1] * A[1][1]) % MOD);

                    res[0][0] = temp[0][0]; res[0][1] = temp[0][1];
                    res[1][0] = temp[1][0]; res[1][1] = temp[1][1];
                }

                temp[0][0] = (int) (((long) A[0][0] * A[0][0] + (long) A[0][1] * A[1][0]) % MOD);
                temp[0][1] = (int) (((long) A[0][0] * A[0][1] + (long) A[0][1] * A[1][1]) % MOD);
                temp[1][0] = (int) (((long) A[1][0] * A[0][0] + (long) A[1][1] * A[1][0]) % MOD);
                temp[1][1] = (int) (((long) A[1][0] * A[0][1] + (long) A[1][1] * A[1][1]) % MOD);

                A[0][0] = temp[0][0]; A[0][1] = temp[0][1];
                A[1][0] = temp[1][0]; A[1][1] = temp[1][1];

                x >>= 1;
            }

            System.out.println(res[0][0] + " " + res[0][1]);
            System.out.println(res[1][0] + " " + res[1][1]);
        }
    }
}
