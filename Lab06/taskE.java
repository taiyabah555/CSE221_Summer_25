import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class taskE {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String [] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(st.nextToken());
        String [] words = new  String[n];

        Set<Character> idk = new HashSet<>();
        for(int i = 0; i<n; i++){
            words[i] = reader.readLine().trim();
            for(char c : words[i].toCharArray()){
                idk.add(c);
            }
        }
        
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for(char c : idk ){
            graph.put(c, new ArrayList<>());
            inDegree.put(c, 0);
        }

        for(int i =0; i<n-1; i++){
            String w1 = words[i];
            String w2 = words[i+1];

            if(w1.length()>w2.length() && w1.startsWith(w2)){
                System.out.println(-1);
                return;
            }

            int minLen = Math.min(w1.length(), w2.length());
            for(int j =0; j<minLen; j++){
                char c1 =w1.charAt(j), c2= w2.charAt(j);
                if(c1!=c2){
                    graph.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2)+1);
                    break;
                }
            }
        }
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for (char c : idk) {
            if (inDegree.get(c) == 0) {
                pq.add(c);
            }
        }
        StringBuilder result = new StringBuilder();
        int vis = 0;

        while (!pq.isEmpty()) {
            char curr = pq.poll();
            result.append(curr);
            vis++;
            for (char neighbor : graph.get(curr)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    pq.add(neighbor);
                }
            }
        }
        if (vis!=idk.size()) {
            System.out.println(-1);
        }
        else{
            System.out.println(result.toString());
        }
        sc.close();
    }
}
