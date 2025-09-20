import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class taskF {

    public static void buildBalancedBST(int[] arr, int left, int right, int[] result, int[] index) {
        if (left > right) {
            return;
        }

        int mid = (left + right) / 2;
        result[index[0]++] = arr[mid];
        buildBalancedBST(arr, left, mid - 1, result, index);
        buildBalancedBST(arr, mid + 1, right, result, index);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        int[] index = new int[1]; 
        index[0] = 0;
        buildBalancedBST(arr, 0, n - 1, result, index);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }

}
