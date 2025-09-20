import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class taskA {
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] N = reader.readLine().trim().split(" ");
        
        int [] arr = new int [Integer.parseInt(N[0])];
        int target = Integer.parseInt(N[1]);

        if((target>=0 && target<=1000000000) && (arr.length>=0 && arr.length<=1000000)) {
            String [] parts = reader.readLine().trim().split(" ");
            for (int i = 0; i < arr.length; i++) {
                arr [i] = Integer.parseInt(parts[i]);
            }
        
            for (int i = 0; i < arr.length-1; i++) {
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[i]+arr[j]==target){
                        System.out.println((i+1)+" "+(j+1));
                        return;
                    }
                }
            
            }
            System.out.println(-1);       
        }
    }
}
