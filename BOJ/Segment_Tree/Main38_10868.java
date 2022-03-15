import java.util.*;
import java.io.*;

public class Main38_10868 {
    static int N, M;
    static int[] A, tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N+1];
        tree = new int[N*4];

        for(int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        init(1, N, 1);

        /*System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(tree));*/

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(getMinimum(1, N, 1, a, b) + "\n");

        }

        System.out.println(sb);

    }

    public static int init(int start, int end, int node) {
        if (start == end) return tree[node] = A[start];

        int mid = (start + end) / 2;
        return tree[node] = Math.min(init(start, mid, node*2), init(mid+1, end, node*2+1));
    }

    public static int getMinimum(int start, int end, int node, int left, int right) {
        if (start > right || end < left) return (int)1e9;

        if (start >= left && end <= right) return tree[node];

        int mid = (start + end) / 2;

        return Math.min(getMinimum(start, mid, node*2, left, right), getMinimum(mid+1, end, node*2+1, left, right));
    }

}