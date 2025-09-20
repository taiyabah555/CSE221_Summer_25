
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class taskB {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] N = reader.readLine().trim().split(" ");
        
        int [] arr1 = new int [Integer.parseInt(N[0])];
        int [] arr2 = new int [Integer.parseInt(N[1])];
        int target = Integer.parseInt(N[2]);       

        String [] parts1 = reader.readLine().trim().split(" ");
        for (int i = 0; i < arr1.length; i++) {
            arr1 [i] = Integer.parseInt(parts1[i]);
        }
        String [] parts2 = reader.readLine().trim().split(" ");
        for (int i = 0; i < arr2.length; i++) {
            arr2 [i] = Integer.parseInt(parts2[i]);
        }
        long min = Math.abs(arr1[0]+arr2[0]-target);
        int a=1 , b=1;

        for (int i = 0; i < arr1.length-1; i++) {
            for (int j = 0; j < arr2.length; j++) {
                long check = Math.abs(arr1[i]+arr2[j]-target);
                if(check<min){
                    min = check;
                    a = i+1;
                    b = j+1;
                }
                else if (check==0){
                    a = i+1;
                    b = j+1;
                    System.out.println(a+" "+b);
                    return;
                }
            }
        }
        System.out.println(a+" "+b);

    }    
}
