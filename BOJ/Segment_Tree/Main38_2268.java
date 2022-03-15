import java.util.*;
import java.io.*;

public class Main38_2268 {
    static int N, M;
    static int[] A;
    static long[] tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N+1];
        tree = new long[N*4];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0) sb.append(Sum(1, N, 1, b, c) + "\n");
            else Modify(1, N, 1, b, c - A[b]);
            
        }

        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(tree));

        System.out.println(sb);

    }

    public static long Sum(int start, int end, int node, int left, int right) {
        if (start > right || end < left) return 0;

        if (start >= left && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return Sum(start, mid, node*2, left, right) + Sum(mid+1, end, node*2+1, left, right);
    }

    public static void Modify(int start, int end, int node, int index, int diff) {
        if (start > index || end < index) return;

        tree[node] += diff;

        if (start >= end) {
            A[start] += diff;
            return;
        }

        int mid = (start + end) / 2;
        Modify(start, mid, node*2, index, diff);
        Modify(mid+1, end, node*2+1, index, diff);
    }

}