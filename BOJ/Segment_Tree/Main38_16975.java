import java.util.*;
import java.io.*;

public class Main38_16975 {
    static int N, M;
    static long[] list, tree, lazy;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new long[N+1];
        tree = new long[N*4];
        lazy = new long[N*4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=1;
        while(st.hasMoreTokens()) {
            list[i] = Long.parseLong(st.nextToken());
            i++;
        }

        init(1, N, 1);
        
        M = Integer.parseInt(br.readLine());

        for(i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A == 1) {
                int C = Integer.parseInt(st.nextToken());
                int D = Integer.parseInt(st.nextToken());
                if (B > C) Update(1, N, 1, C, B, D);
                else Update(1, N, 1, B, C, D);
            } else {
                sb.append(Search(1, N, 1, B) + "\n");
            }
        }
        System.out.println(sb);
    }

    public static long init(int start, int end, int node) {
        if (start == end) return tree[node] = list[start];

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }

    public static long Search(int start, int end, int node, int index) {
        lazy_Update(start, end, node);
        
        if (start > index || end < index) return 0;

        if (start == index && end == index) return tree[node];

        int mid = (start + end) / 2;
        return Search(start, mid, node*2, index) + Search(mid+1, end, node*2+1, index);
    }

    public static void Update(int start, int end, int node, int left, int right, int change) {
        lazy_Update(start, end, node);

        if (start > right || end < left) return;

        if (start >= left && end <= right) {
            lazy[node] += change;
            lazy_Update(start, end, node);
            return;
        }

        int mid = (start + end) / 2;
        Update(start, mid, node*2, left, right, change);
        Update(mid+1, end, node*2+1, left, right, change);
    }

    public static void lazy_Update(int start, int end, int node) {
        if (lazy[node] != 0) {
            tree[node] += ((end - start + 1) * lazy[node]);

            if (start != end) {
                lazy[node*2] += lazy[node];
                lazy[node*2+1] += lazy[node];
            }

            lazy[node] = 0;
        }
    }

}