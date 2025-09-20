import java.io.BufferedReader;
import java.io.InputStreamReader;

public class task8_2 {
    public static int stringCompare(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int n = Math.min(l1, l2);
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
        }
        return l1 - l2;
    }

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] trains = new String[N];
        String[] name = new String[N];
        String[] time = new String[N];

        for (int i = 0; i < N; i++) {
            trains[i] = br.readLine();
            String[] parts = trains[i].split(" will");
            name[i] = parts[0];
            time[i] = trains[i].substring(trains[i].length() - 5);
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (stringCompare(name[j], name[j + 1]) > 0) {
                    swap(name, j, j + 1);
                    swap(time, j, j + 1);
                    swap(trains, j, j + 1);
                } else if (name[j].equals(name[j + 1])) {
                    if (time[j].compareTo(time[j + 1]) < 0) {
                        swap(name, j, j + 1);
                        swap(time, j, j + 1);
                        swap(trains, j, j + 1);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(trains[i]);
        }
    }

}
