import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task4 {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());

        if (T>=0 && T<=10000){
            for(int i = 1; i<=T; i++){
                int N = Integer.parseInt(reader.readLine().trim());
                int [] arr = new int [N];
                String[] parts = reader.readLine().trim().split(" ");
                for (int idx = 0; idx < arr.length; idx++) {
                    arr[idx] = Integer.parseInt(parts[idx]);               
                    }
                int count = 1;
                for (int idx = 0; idx < arr.length-1; idx++) {
                    if(arr[idx] <= arr[idx+1]){ 
                        count++;                      
                    }
                    else break;                        
                }
                if (count == N){
                    System.out.println("YES");
                }
                else System.out.println("NO");
            }
        }

    }
}
