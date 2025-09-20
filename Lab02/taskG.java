import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class taskG {
    public static void main(String [] args)throws IOException{
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String [] N = reader.readLine().trim().split(" ");
        
        int [] arr1 = new int [Integer.parseInt(N[0])];
        int x = Integer.parseInt(N[1]);
        
        String [] parts1 = reader.readLine().trim().split(" ");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(parts1[i]);
        }

        for (int i = 0; i < x; i++) {
            int [] arr2 = new int [2];
            String [] parts2 = reader.readLine().trim().split(" ");
            for (int j = 0; j < arr2.length; j++) {
                arr2[j] = Integer.parseInt(parts2[j]);
            }

            int l = 0, r = arr1.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (arr1[mid] >= arr2[0]) {
                    r = mid;
                } else {
                    l = mid+1;
                }
            }
            int min = l;

            l = 0;
            r = arr1.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (arr1[mid] > arr2[1]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int high = l;

            System.out.println(high-min);
        }
    }
}
