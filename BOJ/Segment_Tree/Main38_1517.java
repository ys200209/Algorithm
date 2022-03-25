import java.util.*;
import java.io.*;

public class Main38_1517 {
    static int N;
    static int[] list, tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N+1];
        tree = new int[N*4];

        for(int i=1; i<=N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        init(1, N, 1);

        System.out.println(Arrays.toString(tree));

        for(int i=1; i<=N; i++) {
            sb.append(Search(1, N, 1, list[i]) + "\n");
        }
        System.out.println("--------------------");
        System.out.println(sb);
    }

    public static int init(int start, int end, int node, int w) {
        if (start == end) return tree[node] = list[start];

        int mid = (start + end) / 2;
        return tree[node] = Math.max(init(start, mid, node*2), init(mid+1, end, node*2+1));
    }

    public static int Search(int start, int end, int node, int w) {
        if (start == end) return 0;

        if (tree[node] <= w) return node;

        int mid = (start + end) / 2;
        return Math.max(Search(start, mid, node*2, w), Search(mid+1, end, node*2+1, w));
    }

}