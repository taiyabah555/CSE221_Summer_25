import java.util.Scanner;

public class TrainScheduleSorter {

    static class Train {
        String line;
        String name;
        int hour;
        int minute;
        int index; 

        Train(String line, int index) {
            this.line = line;
            this.index = index;

            int idx = line.indexOf(" will departure for");
            this.name = line.substring(0, idx);

            int timeIdx = line.lastIndexOf("at") + 3;
            String timeStr = line.substring(timeIdx);
            this.hour = Integer.parseInt(timeStr.substring(0, 2));
            this.minute = Integer.parseInt(timeStr.substring(3, 5));
        }
    }

    static void swap(Train[] arr, int i, int j) {
        Train temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sortTrains(Train[] trains, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compare(trains[j], trains[j + 1]) > 0) {
                    swap(trains, j, j + 1);
                }
            }
        }
    }

    static int compare(Train a, Train b) {
        int nameCmp = a.name.compareTo(b.name);
        if (nameCmp != 0) {
            return nameCmp;
        }
        if (a.hour != b.hour) {
            return b.hour - a.hour;
        }
        if (a.minute != b.minute) {
            return b.minute - a.minute;
        }
        return a.index - b.index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Train[] trains = new Train[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            trains[i] = new Train(line, i);
        }

        sortTrains(trains, n);

        for (int i = 0; i < n; i++) {
            System.out.println(trains[i].line);
        }
    }
}
