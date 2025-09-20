import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task7 {
     public static void main(String [] args) throws IOException{
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine().trim());
        int [] S = new int [N];
        int [] mark = new int [N];
        int swap = 0;

        if (N>=0 && N<=1000) {           
            String[] parts = reader.readLine().trim().split(" ");
            for (int idx = 0; idx < S.length; idx++) {
                S[idx] = Integer.parseInt(parts[idx]);               
            }
                           
            parts = reader.readLine().trim().split(" ");
            for (int idx = 0; idx < mark.length; idx++) {
                mark[idx] = Integer.parseInt(parts[idx]);               
            }           
        }
        
        for (int i = 0; i<N-1; i++) {
            int maxIdx = i;
            for (int j = i+1; j<N; j++) {
                if (mark[j]>mark[maxIdx]) {
                    maxIdx = j;
                } 
                else if (mark[j]==mark[maxIdx] && S[j]<S[maxIdx]) {
                    maxIdx = j;
                }
            }
            if (maxIdx!=i) {
                int tempMark = mark[i];
                mark[i] = mark[maxIdx];
                mark[maxIdx] = tempMark;

                int tempId = S[i];
                S[i] = S[maxIdx];
                S[maxIdx] = tempId;

                swap++;
            }
        }
        System.out.println("Minimum swaps: " + swap);
        for (int i = 0; i < N; i++) {
            System.out.println("ID: " + S[i] + " Mark: " + mark[i]);
        }
            
    }
}
