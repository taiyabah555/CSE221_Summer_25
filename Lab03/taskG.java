import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class taskG {
    static int preIndex = 0;
    static List<Integer> postOrder = new ArrayList<>();

    static void buildPostOrder(int[] inOrder, int[] preOrder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (inStart > inEnd) {
            return;
        }
        int root = preOrder[preIndex++];
        int inRoot = inMap.get(root);
        buildPostOrder(inOrder, preOrder, inStart, inRoot - 1, inMap);
        buildPostOrder(inOrder, preOrder, inRoot + 1, inEnd, inMap);
        postOrder.add(root);
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] inOrder = new int[N];
        int[] preOrder = new int[N];
        String[] inOrderStr = br.readLine().split(" ");
        String[] preOrderStr = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(inOrderStr[i]);
            preOrder[i] = Integer.parseInt(preOrderStr[i]);
        }

        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            inMap.put(inOrder[i], i);
        }

        buildPostOrder(inOrder, preOrder, 0, N - 1, inMap);
        StringBuilder sb = new StringBuilder();
        for (int num : postOrder) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}