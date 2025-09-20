import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class taskF {
     public static void main(String [] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] jinish = reader.readLine().trim().split(" ");
        
        int [] N = new int [Integer.parseInt(jinish[0])];
        int K = Integer.parseInt(jinish[1]);

        String [] parts = reader.readLine().trim().split(" ");
        for (int i = 0; i < N.length; i++) {
            N [i] = Integer.parseInt(parts[i]);
        }

        int [] arr = new int [N.length+1];
        int left = 0, countDis =0, maxLen = 0;

        for (int right = 0; right<N.length ; right++) {
            if(arr[N[right]]==0){
                countDis++;
            }
            arr[N[right]]++;
            
            while(countDis>K){
                arr[N[left]]--;
                if (arr[N[left]]==0){
                    countDis--;
                }
                left++;
            }

            int currLen = right-left+1;
            if(currLen>maxLen){
                maxLen = currLen;
            }
        } 
        System.out.print(maxLen);
    }   
}
