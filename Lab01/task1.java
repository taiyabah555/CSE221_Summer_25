import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());
        
        for(int i = 1; i <= testCases; i++ ){
            int number = Integer.parseInt(reader.readLine().trim());
            if(number%2==0){
                System.out.println(number +" is an Even number.");
            }
            else{
                System.out.println(number +" is an Odd number.");
            }
            
        }
    }
}
