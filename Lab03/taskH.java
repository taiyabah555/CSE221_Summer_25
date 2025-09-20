import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class taskH {
    static int postIndex;
    static List<Integer> preOrder = new ArrayList<>();
 
    static void buildPreOrder(int[] inOrder, int[] postOrder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (inStart > inEnd) {
            return;
        }
        int root = postOrder[postIndex--];
        int inRoot = inMap.get(root);
        buildPreOrder(inOrder, postOrder, inRoot + 1, inEnd, inMap);
        buildPreOrder(inOrder, postOrder, inStart, inRoot - 1, inMap);
        preOrder.add(root);
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] inOrder = new int[N];
        int[] postOrder = new int[N];
 
        String[] inOrderStr = br.readLine().split(" ");
        String[] postOrderStr = br.readLine().split(" ");
 
        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(inOrderStr[i]);
            postOrder[i] = Integer.parseInt(postOrderStr[i]);
        }
 
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            inMap.put(inOrder[i], i);
        }
        
        postIndex = N - 1;
        buildPreOrder(inOrder, postOrder, 0, N - 1, inMap);
 
        Collections.reverse(preOrder);
        StringBuilder sb = new StringBuilder();
 
        for (int num : preOrder) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}