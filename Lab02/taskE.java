import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class taskE {
    public static void main(String [] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] jinish = reader.readLine().trim().split(" ");

        int [] n = new int [Integer.parseInt(jinish[0])];
        int x = Integer.parseInt(jinish[1]), count = 0, sum = 0;

        String [] parts = reader.readLine().trim().split(" ");
        for (int i = 0; i < n.length; i++) {
            n [i] = Integer.parseInt(parts[i]);
        }

        int left = 0;
        for (int right = 0; right < n.length; right++) {
            sum += n[right];

            while (sum > x) {
                sum -= n[left];
                left++;
            }

            int currLen = right - left + 1;
            if (currLen > count) {
                count = currLen;
            }
        }

        System.out.println(count);        
    }
}
