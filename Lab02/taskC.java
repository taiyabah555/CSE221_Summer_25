import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class taskC {
    public static void main(String [] args) throws IOException{
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String [] N = reader.readLine().trim().split(" ");
        
        int [] n = new int [Integer.parseInt(N[0])];
        int x = Integer.parseInt(N[1]);       

        String [] parts = reader.readLine().trim().split(" ");
        for (int i = 0; i < n.length; i++) {
            n [i] = Integer.parseInt(parts[i]);
        }
        int[] index = new int[n.length];
        for (int i = 0; i < n.length; i++) {
            index[i] = i+1; 
        }

        for (int i = 0; i < n.length - 1; i++) {
            for (int j = i + 1; j < n.length; j++) {
                if (n[i] > n[j]) {
                    int temp = n[i];
                    n[i] = n[j];
                    n[j] = temp;

                    int tempIdx = index[i];
                    index[i] = index[j];
                    index[j] = tempIdx;
                }
            }
        }

        for (int i = 0; i < n.length - 2; i++) {
            int l = i+1;
            int r = n.length-1;
            while (l<r) {
                long sum = (long)n[i] + n[l] + n[r];
                if (sum==x) {
                    System.out.println(index[i]+" "+index[l]+" "+index[r]);
                    return;
                } else if (sum<x) {
                    l++;
                } else {
                    r--;
                }
            }
        }
    System.out.println("-1");
    }
}
