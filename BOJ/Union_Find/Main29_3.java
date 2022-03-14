import java.util.*;
import java.io.*;

public class Main29_3 {
    static int T, F, count=0;
    static Map<String, Integer> map;
    static ArrayList<Integer> parents;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            map = new HashMap<>();
            parents = new ArrayList<>();
            parents.add(0);
            F = Integer.parseInt(br.readLine());
            for(int i=0; i<F; i++) {
                count = 0;
                st = new StringTokenizer(br.readLine(), " ");
                String A = st.nextToken();
                String B = st.nextToken();
    
                if (map.get(A) == null) {
                    map.put(A, map.size()+1);
                    parents.add(map.size());
                }
                if (map.get(B) == null) {
                    map.put(B, map.size()+1);
                    parents.add(map.size());
                }

                System.out.println("(1)");
                System.out.println(A + " : " + map.get(A));
                System.out.println(B + " : " + map.get(B));
                union(A, B);
                System.out.println("(2)");
                System.out.println(A + " : " + map.get(A));
                System.out.println(B + " : " + map.get(B));

                // System.out.println(A + ", " + B + " is Same? " + isSameParent(A, B));
                sb.append(count + "\n");
                // System.out.println("map.size() : " + map.size() + ", list.size() : " + parents.size());
            }

            for(String name : map.keySet()) {
                System.out.println(name + " : " + map.get(name));
            }
            
        }

        System.out.println("--------------------");
        System.out.println(sb);

    }

    public static void union(String A, String B) {
        int rootA = find(A, map.get(A));
        int rootB = find(B, map.get(B));

        // System.out.println("(union) A : " + A + ", B : " + B + "\nrootA : " + rootA + ", rootB : " + rootB);

        if (rootA < rootB) {
            map.put(B, rootA);
            parents.set(rootB, rootA);
        }
        else {
            map.put(A, rootB);
            parents.set(rootA, rootB);
        }
        count = 2;
        return;
    }

    public static int find(String P, int root) {
        if (parents.get(root) == root) return root;

        int r = find(P, parents.get(root));
        map.put(P, r);
        parents.set(root, r);
        return parents.get(root);
        // return parents[root] = find(parents[root]);
    }

    public static boolean isSameParent(String A, String B) {
        int rootA = find(A, map.get(A));
        int rootB = find(B, map.get(B));

        if (rootA == rootB) return true;
        else return false;
    }

}
