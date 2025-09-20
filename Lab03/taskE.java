import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class taskE{ 
    public static long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod; 
        while (exp > 0) {
            if (exp % 2 == 1) { 
                res = (res * base) % mod;
            }
            base = (base * base) % mod; 
            exp /= 2; 
        }
        return res;
    }
 
    public static long calculateSum(long a, long n, long m) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return a % m;
        }
 
        long half_n = n / 2;
        long sum_half = calculateSum(a, half_n, m); 
        long a_power_half_n = power(a, half_n, m);
 
        long result;
        if (n % 2 == 0) {
            result = (sum_half * (1 + a_power_half_n)) % m;
        }
        else{
            long sum_2k = (sum_half * (1 + a_power_half_n)) % m;
            long a_power_n = (a_power_half_n * a_power_half_n) % m;
            a_power_n = (a_power_n * (a % m)) % m;             
            result = (sum_2k + a_power_n) % m;
        }
        return (result + m) % m; 
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken()); 
            sb.append(calculateSum(a, n, m)).append("\n");
        }
        System.out.print(sb.toString());
    }
}
