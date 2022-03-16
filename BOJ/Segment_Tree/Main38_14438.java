import java.util.*;
import java.io.*;

public class Main38_14438 {
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

        init(1, N, 1);

        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(tree));

        M = Integer.parseInt(br.readLine());

        for(i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int command = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (command == 1) {
                Update(1, N, 1, x, y);
                A[x] = y;
            } else {
                if (x > y) sb.append(Search(1, N, 1, y, x) + "\n");
                else sb.append(Search(1, N, 1, x, y) + "\n");
            }
        }
        
        System.out.println("------------------------");
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(tree));
        System.out.println(sb);

    }

    public static int init(int start, int end, int node) {
        if (start == end) return tree[node] = A[start];

        int mid = (start + end) / 2;
        return tree[node] = Math.min(init(start, mid, node*2), init(mid+1, end, node*2+1));
    }

    public static int Search(int start, int end, int node, int left, int right) {
        if (start > right || end < left) return (int)1e9+1;

        if (start >= left && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return Math.min(Search(start, mid, node*2, left, right), Search(mid+1, end, node*2+1, left, right));
    }

    public static int Update(int start, int end, int node, int index, int change) {
        if (start > index || end < index) return tree[node];

        if (start == end) return tree[node] = change;

        int mid = (start + end) / 2;
        return tree[node] = Math.min(Update(start, mid, node*2, index, change), Update(mid+1, end, node*2+1, index, change));
    }

}