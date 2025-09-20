import java.io.*;
import java.util.*;

public class taskB {
    static class FenwickTree {
        int size;
        int[] tree;

        FenwickTree(int size) {
            this.size = size;
            this.tree = new int[size + 1];
        }

        void update(int index, int delta) {
            while (index <= size) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        int query(int index) {
            int res = 0;
            while (index > 0) {
                res += tree[index];
                index -= index & -index;
            }
            return res;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] elements = br.readLine().split(" ");
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(elements[i]);
        }

        Set<Long> uniqueValues = new HashSet<>();
        for (long num : A) {
            uniqueValues.add(num);
            uniqueValues.add(num * num);
        }
        List<Long> sortedUniqueValues = new ArrayList<>(uniqueValues);
        Collections.sort(sortedUniqueValues);

        Map<Long, Integer> valueToRank = new HashMap<>();
        for (int i = 0; i < sortedUniqueValues.size(); i++) {
            valueToRank.put(sortedUniqueValues.get(i), i + 1);
        }

        FenwickTree fenwickTree = new FenwickTree(sortedUniqueValues.size());
        long result = 0;

        for (int j = 0; j < N; j++) {
            long squared = A[j] * A[j];
            int rank = valueToRank.getOrDefault(squared, 0);
            int count = fenwickTree.query(sortedUniqueValues.size()) - fenwickTree.query(rank);
            result += count;
            fenwickTree.update(valueToRank.get(A[j]), 1);
        }

        System.out.println(result);
    }
}