import java.util.*;
import java.io.*;

public class Main38_12837 {
    static int N, Q;
    static int[] list;
    static long[] tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        list = new int[N+1];
        tree = new long[N*4];

        for(int i=1; i<=Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            if (command == 1) {
                Update(1, N, 1, p, q);
            } else {
                sb.append(Query(1, N, 1, p, q) + "\n");
            }
        }
        System.out.println(sb);
    }

    public static long Update(int start, int end, int node, int index, int x) {
        if (start > index || end < index) return tree[node];

        if (start == end) return tree[node] += x;

        int mid = (start + end) / 2;
        return tree[node] = Update(start, mid, node*2, index, x) + Update(mid+1, end, node*2+1, index, x);
    }

    public static long Query(int start, int end, int node, int left, int right) {
        if (start > right || end < left) return 0;

        if (start >= left && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return Query(start, mid, node*2, left, right) + Query(mid+1, end, node*2+1, left, right);
    }

}