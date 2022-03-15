import java.util.*;
import java.io.*;

public class Main38_9345 {
    static int T, N, K;
    static String[] num;
    static ArrayList<String>[] tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            num = new String[N];
            tree = new ArrayList[N*4];
            for(int i=0; i<N*4; i++) {
                tree[i] = new ArrayList<>();
            }

            for(int i=0; i<N; i++) {
                num[i] = Integer.toString(i);
            }

            init(0, N-1, 1);
            
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int Q = Integer.parseInt(st.nextToken());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                if (Q == 1) {
                    ArrayList<String> result = Add(0, N-1, 1, A, B);
                    boolean isEquals = true;
                    for(int j=A; j<=B; j++) {
                        if (!result.contains(Integer.toString(j))) {
                            isEquals = false;
                            break;
                        }
                    }
                    if (isEquals) sb.append("YES\n");
                    else sb.append("NO\n");
                } else {
                    String s1 = num[A];
                    String s2 = num[B];
                    Update(0, N-1, 1, A, s2);
                    Update(0, N-1, 1, B, s1);
                    num[A] = s2;
                    num[B] = s1;
                }
            }

        }
        System.out.println(sb);
    }

    public static ArrayList<String> init(int start, int end, int node) {
        if (start == end) {
            tree[node].add(num[start]);
            return tree[node];
        }

        int mid = (start + end) / 2;
        for(String s : init(start, mid, node*2)) {
            tree[node].add(s);
        }

        for(String s : init(mid+1, end, node*2+1)) {
            tree[node].add(s);
        }

        return tree[node];
    }

    public static ArrayList<String> Add(int start, int end, int node, int left, int right) {
        if (start > right || end < left) return null;

        if (start >= left && end <= right) return tree[node];

        int mid = (start + end) / 2;
        ArrayList<String> list1 = Add(start, mid, node*2, left, right);
        ArrayList<String> list2 = Add(mid+1, end, node*2+1, left, right);

        ArrayList<String> list = new ArrayList<>();
        if (list1 != null) {
            for(String s : list1) {
                list.add(s);
            }
        }

        if (list2 != null) {
            for(String s : list2) {
                list.add(s);
            }
        }
        return list;
    }

    public static ArrayList<String> Update(int start, int end, int node, int index, String change) {
        if (start > index || end < index) return tree[node];

        if (start == end) {
            tree[node].set(0, change);
            return tree[node];
        }

        tree[node] = new ArrayList<>();
        int mid = (start + end) / 2;
        for(String s : Update(start, mid, node*2, index, change)) {
            tree[node].add(s);
        }

        for(String s : Update(mid+1, end, node*2+1, index, change)) {
            tree[node].add(s);
        }

        return tree[node];
    }

}