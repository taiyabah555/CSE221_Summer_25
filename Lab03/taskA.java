import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class taskA {

private static long inversionCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] elements = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(elements[i]);
        }

        inversionCount = 0;
        int[] sortedArr = mergeSort(arr, 0, N - 1);

        System.out.println(inversionCount);
        StringBuilder sb = new StringBuilder();
        for (int num : sortedArr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static int[] mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return new int[]{arr[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftArr = mergeSort(arr, left, mid);
        int[] rightArr = mergeSort(arr, mid + 1, right);
        return merge(leftArr, rightArr);
    }

    private static int[] merge(int[] leftArr, int[] rightArr) {
        int[] merged = new int[leftArr.length + rightArr.length];
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                merged[k++] = leftArr[i++];
            } else {
                merged[k++] = rightArr[j++];
                inversionCount += leftArr.length - i;
            }
        }
        while (i < leftArr.length) {
            merged[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            merged[k++] = rightArr[j++];
        }
        return merged;
    }
}