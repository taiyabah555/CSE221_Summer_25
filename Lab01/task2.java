import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task2 {
    public static void main(String [] args) throws IOException{
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());

        if (T>=0 && T<=10000){
          for(int i = 1; i <= T; i++ ){
            // float num1 = Float.parseFloat(reader.readLine().trim());
            // String operator = reader.readLine().trim();
            // float num2 = Float.parseFloat(reader.readLine().trim());

            String[] parts = reader.readLine().trim().split(" ");
            float num1 = Float.parseFloat(parts[1]);
            String operator = parts[2];
            float num2 = Float.parseFloat(parts[3]);

              switch (operator) {
                  case "+" ->                       {
                          float res = num1+num2;
                          System.out.println(res);
                      }
                  case "-" ->                       {
                          float res = num1-num2;
                          System.out.println(res);
                      }
                  case "*" ->                       {
                          float res = num1*num2;
                          System.out.println(res);
                      }
                  default ->                       {
                          float res = num1/num2;
                          System.out.println(res);
                      }
              }
        }
          
    }
}
}
   