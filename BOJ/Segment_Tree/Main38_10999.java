import java.util.*;
import java.io.*;

public class Main38_10999 {
    static int N, M, K;
    static long[] list, tree, lazy;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new long[N+1];
        tree = new long[N*4];
        lazy = new long[N*4];

        for(int i=1; i<=N; i++) {
            list[i] = Long.parseLong(br.readLine());
        }

        init(1, N, 1);

        for(int i=0; i<M+K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            long D = 0;
            if (A == 1) {
                D  = Long.parseLong(st.nextToken());
                Update(1, N, 1, B, C, D);
            } else {
                if (B > C) sb.append(Sum(1, N, 1, C, B) + "\n");
                else sb.append(Sum(1, N, 1, B, C) + "\n");
            }
            
        }
        System.out.println(sb);
    }

    public static long init(int start, int end, int node) {
        if (start == end) return tree[node] = list[start];

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }

    public static long Sum(int start, int end, int node, int left, int right) {
        lazy_Update(start, end, node);

        if (start > right || end < left) return 0;

        if (start >= left && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return Sum(start, mid, node*2, left, right) + Sum(mid+1, end, node*2+1, left, right);
    }

    public static long Update(int start, int end, int node, int left, int right, long change) {
        lazy_Update(start, end, node);

        if (start > right || end < left) return tree[node];

        if (start >= left && end <= right) {
            lazy[node] += change;

            lazy_Update(start, end, node);
            return tree[node];
        }

        int mid = (start + end) / 2;
        return tree[node] = Update(start, mid, node*2, left, right, change) + Update(mid+1, end, node*2+1, left, right, change);
    }

    public static void lazy_Update(int start, int end, int node) {
        if (lazy[node] != 0) {

            tree[node] += ((end - start + 1) * lazy[node]);

            if (start != end) {
                lazy[node*2] += lazy[node]; // 전파
                lazy[node*2+1] += lazy[node]; // 전파
            }

            lazy[node] = 0;
        }
    }

}