import java.util.*;
import java.io.*;

public class Main38_1395 {
    static int N, M;
    static int[] list, tree, lazy;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N+1];
        tree = new int[N*4];
        lazy = new int[N*4];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (command == 0) {
                if (A > B) Update(1, N, 1, B, A);
                else Update(1, N, 1, A, B);
            } else {
                if (A > B) sb.append(Query(1, N, 1, B, A) + "\n");
                else sb.append(Query(1, N, 1, A, B) + "\n");
            }
        }
        System.out.println(sb);
    }

    public static int Query(int start, int end, int node, int left, int right) {
        lazy_Update(start, end, node);

        if (start > right || end < left) return 0;

        if (start >= left && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return Query(start, mid, node*2, left, right) + Query(mid+1, end, node*2+1, left, right);
    }

    public static int Update(int start, int end, int node, int left, int right) {
        lazy_Update(start, end, node);

        if (start > right || end < left) return tree[node];

        if (start >= left && end <= right) {
            lazy[node] += 1;

            lazy_Update(start, end, node);

            return tree[node];
        }

        int mid = (start + end) / 2;
        return tree[node] = Update(start, mid, node*2, left, right) + Update(mid+1, end, node*2+1, left, right);
    }

    public static void lazy_Update(int start, int end, int node) {
        if (lazy[node] != 0) {
            if (lazy[node] % 2 == 0) {
                lazy[node] = 0;
                return;
            }

            tree[node] = (end - start + 1) - tree[node];

            if (start != end) {
                lazy[node*2] += lazy[node];
                lazy[node*2+1] += lazy[node];
            }

            lazy[node] = 0;
        }
    }
}
