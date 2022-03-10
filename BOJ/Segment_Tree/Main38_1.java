import java.io.*;
import java.util.*;

public class Main38_1 {
    static int N, M;
    static int[] A, tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        tree = new int[N*4];

        st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        
        init(0, N-1, 1);

        // System.out.println(Arrays.toString(tree));

        for(i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int LEFT = Integer.parseInt(st.nextToken());
            int RIGHT = Integer.parseInt(st.nextToken());

            sb.append(SUM(0, N-1, 1, LEFT-1, RIGHT-1) + "\n");
        }
        System.out.println(sb);
    }

    public static int init(int start, int end, int node) {
        if (start >= end) return tree[node] = A[start];

        int mid = (start + end) / 2;

        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2 + 1);
    }

    public static int SUM(int start, int end, int node, int left, int right) {
        if (start > right || end < left) return 0;

        if (start >= left && end <= right) return tree[node];

        // if (start >= end) return tree[node];

        int mid = (start + end) / 2;
        return SUM(start, mid, node*2, left, right) + SUM(mid+1, end, node*2 + 1, left, right);
    }
    
}