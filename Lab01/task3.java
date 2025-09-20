import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task3 {
    public static void main(String [] args) throws IOException{
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());

        if (T>=0 && T<=10000) {
            for(int i = 1; i<=T; i++) {
                long num = Integer.parseInt(reader.readLine().trim());
                if (num>=0 && num<=1000000) {
                    System.out.println(num*(num+1)/2);
                }
            }
        }
    }
}
