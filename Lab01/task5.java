import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task5 {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine().trim());
        int[] a = new int[n];
        String[] input = reader.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        int evenCount = (n+1)/2;
        int oddCount = n/2;

        int[] even_arr = new int[evenCount];
        int[] odd_arr = new int[oddCount];

        int one = 0, two = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even_arr[one++] = a[i];
            } else {
                odd_arr[two++] = a[i];
            }
        }

        bubbleSort(even_arr);
        bubbleSort(odd_arr);

        int[] sortedA = new int[n];
        for (int i = 0; i < n; i++) {
            sortedA[i] = a[i];
        }

        bubbleSort(sortedA);
        int[] evenS = new int[evenCount];
        int[] oddS = new int[oddCount];

        one = 0;
        two = 0;
        for (int i = 0; i < n; i++) {
            if (i%2 == 0) {
                evenS[one++] = sortedA[i];
            } else {
                oddS[two++] = sortedA[i];
            }
        }

        boolean isSame = true;
        for (int i = 0; i < evenCount; i++) {
            if (even_arr[i] != evenS[i]) {
                isSame = false;
                break;
            }
        }
        if (isSame) {
            for (int i = 0; i < oddCount; i++) {
                if (odd_arr[i] != oddS[i]) {
                    isSame = false;
                    break;
                }
            }
        }

        if (isSame) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    
}
