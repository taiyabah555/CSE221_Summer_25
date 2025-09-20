import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class taskD {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(reader.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(reader.readLine());
        for (int j = 0; j < M; j++) {
            B[j] = Integer.parseInt(st.nextToken());
        }
        
        int[] lastArr = new int[N + M];
        int i = 0, j = 0, k = 0;
        
        while (i < N && j < M) {
            if (A[i] <= B[j]) {
                lastArr[k++] = A[i++];
            } else {
                lastArr[k++] = B[j++];
            }
        }
        
        while (i < N) {
            lastArr[k++] = A[i++];
        }
        
        while (j < M) {
            lastArr[k++] = B[j++];
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num : lastArr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}