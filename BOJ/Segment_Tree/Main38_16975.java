import java.util.*;
import java.io.*;

public class Main38_16975 {
    static int N, M;
    static int[] A, tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tree = new int[N*4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        init(1, N, 1);

        M = Integer.parseInt(br.readLine());
        for(i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                Update(1, N, 1, a, b, c);
            } else {
                int index = Integer.parseInt(st.nextToken());
                sb.append(search(1, N, 1, index) + "\n");
            }
            
        }
        System.out.println(sb);
    }

    public static int init(int start, int end, int node) {
        if (start >= end) return tree[node] = A[start];

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2 + 1);
    }

    public static int search(int start, int end, int node, int index) {
        if (start > index || end < index) return 0;

        if (start == end) return tree[node];

        int mid = (start + end) / 2;
        return Math.max(search(start, mid, node*2, index), search(mid+1, end, node*2+1, index));
    }

    public static int Update(int start, int end, int node, int left, int right, int diff) {
        if (start > right || end < left) return tree[node];

        if (start == end) return tree[node] += diff;

        int mid = (start + end) / 2;
        return tree[node] = Update(start, mid, node*2, left, right, diff) + Update(mid+1, end, node*2+1, left, right, diff);
    }

}
