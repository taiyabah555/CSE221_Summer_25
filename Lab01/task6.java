
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task6 {
    public static void main(String[] args) throws IOException{
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(reader.readLine().trim());
       int [] arr = new int [N];

       if(N>=1 && 10000>=N){         
        String[] parts = reader.readLine().trim().split(" ");
        for (int i = 0; i < N; i++) {
            arr [i] = Integer.parseInt(parts[i]);
        }
       }
       if(N>1){
        for(int j = 0; j< N; j++){
            for(int k =0; k<N-1; k++){         
                if(((arr[k]%2==0 && arr[k+1]%2==0)||(arr[k]%2!=0 && arr[k+1]%2!=0)) && (arr[k]>arr[k+1])){          
                    int temp = arr[k];
                    arr[k] = arr[k+1];
                    arr[k+1] = temp;
                }
            }
        }
        for (int m = 0; m < N; m++) {
           System.out.print(arr[m]+" ");
        }
        }
        else System.out.print(arr[0]);
    }
}
