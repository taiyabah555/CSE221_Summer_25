import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class taskC {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken()); 
        
        long res = 1;
        a %= 107;
        while (b>0){
            if(b%2==1){
                res = (res*a)%107;
            }
            a = (a*a)%107;
            b /= 2;
        }
        System.out.println(res);
    }
}
