import java.util.*;
import java.io.*;

public class Main38_12846 {
    static int N;
    static int[] list, tree;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N+1];
        tree = new int[N*4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=1;
        while(st.hasMoreTokens()) {
            list[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        init(1, N, 1);

        System.out.println(Arrays.toString(tree));

        System.out.println(tree[1]);
    }

    public static int init(int start, int end, int node) {
        if (start == end) return tree[node] = list[start];

        int mid = (start + end) / 2;
        return tree[node] = Math.min(init(start, mid, node*2) * (mid - start + 1), 
        init(mid+1, end, node*2+1) * (end - mid + 1));

    }

}