import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task8 {
    public static void swap(String[] trains, String[] names, String[] times, int i, int j) {
        String tempTrain = trains[i];
        trains[i] = trains[j];
        trains[j] = tempTrain;

        String tempName = names[i];
        names[i] = names[j];
        names[j] = tempName;

        String tempTime = times[i];
        times[i] = times[j];
        times[j] = tempTime;
    }

    public static int stringCompare(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int minLen = (len1 < len2) ? len1 : len2;

        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
        }
        return len1 - len2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine().trim());
        String[] trains = new String[N];
        String[] names = new String[N];
        String[] times = new String[N];

        if (N > 0 && N <= 100) {
            for (int i = 0; i < N; i++) {
                trains[i] = reader.readLine().trim();

                String name = "";
                for (int j = 0; j < trains[i].length(); j++) {
                    if (trains[i].charAt(j) == ' ' && trains[i].charAt(j + 1) == 'w'
                        && trains[i].charAt(j + 2) == 'i' && trains[i].charAt(j + 3) == 'l'
                        && trains[i].charAt(j + 4) == 'l') {
                        break;
                    }
                    name += trains[i].charAt(j);
                }
                names[i] = name;

                String time = "";
                int len = trains[i].length();
                    for (int k = len - 5; k < len; k++) {
                    time += trains[i].charAt(k);
                    }
                times[i] = time;
            }

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (stringCompare(names[i], names[j]) > 0) {
                        swap(trains, names, times, i, j);
                    } else if (stringCompare(names[i], names[j]) == 0) {
                        if (stringCompare(times[i], times[j]) < 0) {
                            swap(trains, names, times, i, j);
                        }
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                System.out.println(trains[i]);
            }
        }
    }
}