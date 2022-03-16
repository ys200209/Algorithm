import java.util.*;
import java.io.*;

public class Main38_13537 {
    static int N, M;
    static int[] A, tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tree = new int[N*4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=1;
        while(st.hasMoreTokens()) {
            A[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        M = Integer.parseInt(br.readLine());

        for(i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (x > y) sb.append(Update(1, N, 1, y, x, k) + "\n");
            else sb.append(Update(1, N, 1, x, y, k) + "\n");
            
        }
        System.out.println(sb);
    }

    /*public static int init(int start, int end, int node, int K) {
        if (start == end) return tree[node] = A[start] > K ? 1 : 0;

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node*2, K) + init(mid+1, end, node*2+1, K);
    }

    public static int Search(int start, int end, int node, int left, int right, int K) {
        if (start > right || end < left) return 0;

        if (start >= left && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return Search(start, mid, node*2, left, right, K) + Search(mid+1, end, node*2+1, left, right, K);
    }*/

    public static int Update(int start, int end, int node, int left, int right, int K) {
        if (start > right || end < left) return 0;

        if (start == end) return tree[node] = A[start] > K ? 1 : 0;

        int mid = (start + end) / 2;
        return tree[node] = Update(start, mid, node*2, left, right, K) + Update(mid+1, end, node*2+1, left, right, K);
    }

}