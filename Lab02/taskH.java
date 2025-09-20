import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class taskH {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();
        
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            long k = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            
            long result;
            if (k<x) {
                result = k;
            } 
            else{
                result = k + ((k-1)/(x-1));
            }
            output.append(result).append("\n");
        }        
        System.out.print(output);
    }
}
