import java.util.*;
import java.io.*;

public class Main38_3 {
    static int MOD = 1000000007;
    static int N, M, K;
    static long[] number, tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        number = new long[N+1];
        tree = new long[N*4];

        for(int i=1; i<=N; i++) {
            number[i] = Long.parseLong(br.readLine());
        }

        init(1, N, 1);

        for(int i=0; i<M+K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            long C = Long.parseLong(st.nextToken());

            if (A == 1) {
                update(1, N, 1, B, C);
                number[B] = C;
            } else {
                sb.append(multi(1, N, 1, B, (int)C) + "\n");
            }
        }
        System.out.println(sb);
    }

    public static long init(int start, int end, int node) {
        if (start >= end) return tree[node] = number[start];

        int mid = (start + end) / 2;
        return tree[node] = (init(start, mid, node*2) * init(mid+1, end, node*2 + 1)) % MOD;
    }

    public static long multi(int start, int end, int node, int left, int right) {
        if (start > right || end < left) return 1;

        if (start >= left && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return (multi(start, mid, node*2, left, right) * multi(mid+1, end, node*2+1, left, right)) % MOD;
    }

    public static long update(int start, int end, int node, int index, long diff) {
        if (start > index || end < index) return tree[node];

        if (start == end) return tree[node] = diff;

        int mid = (start + end) / 2;

        return tree[node] = (update(start, mid, node*2, index, diff) * update(mid+1, end, node*2+1, index, diff)) % MOD;
    }

}