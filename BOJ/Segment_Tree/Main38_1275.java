import java.util.*;
import java.io.*;

public class Main38_1275 {
    static int N, Q;
    static int[] A;
    static long[] tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        A = new int[N];
        tree = new long[N*4];

        st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        // System.out.println(Arrays.toString(A));
        init(0, N-1, 1);
        // System.out.println(Arrays.toString(tree));

        for(i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (x > y) {
                sb.append(sum(0, N-1, 1, y-1, x-1) + "\n");
            } else {
                sb.append(sum(0, N-1, 1, x-1, y-1) + "\n");
            }

            /*System.out.println("[before]");
            System.out.println(Arrays.toString(tree));*/
            update(0, N-1, 1, a-1, b-A[a-1]);
            /*System.out.println("[after]");
            System.out.println(Arrays.toString(tree));

            System.out.println("result : " + result);*/
        }

        System.out.println(sb);

    }

    public static long init(int start, int end, int node) {
        if (start == end) return tree[node] = A[start];

        int mid = (start + end) / 2;
        
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }

    public static long sum(int start, int end, int node, int left, int right) {
        if (start > right || end < left) return 0;

        if (start >= left && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }

    public static void update(int start, int end, int node, int index, int diff) {
        if (start > index || end < index) return;

        tree[node] += diff;

        if (start == end) {
            A[start] += diff;
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node*2, index, diff);
        update(mid+1, end, node*2+1, index, diff);
    }

}