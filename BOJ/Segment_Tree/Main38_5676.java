import java.util.*;
import java.io.*;

public class Main38_5676 {
    static int N, K;
    static int[] A, tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;

        while((str = br.readLine()) != null) {
            N = Integer.parseInt(str.split(" ")[0]);
            K = Integer.parseInt(str.split(" ")[1]);
            A = new int[N+1];
            tree = new int[N*4];

            st = new StringTokenizer(br.readLine(), " ");
            int i=1;
            int num;
            while(st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());

                if (num < 0) A[i] = -1;
                else if (num == 0) A[i] = 0;
                else A[i] = 1;

                i++;
            }

            init(1, N, 1);

            for(i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String command = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                int result;
                if (command.equals("P")) {
                    if (a > b) result = Multi(1, N, 1, b, a);
                    else result = Multi(1, N, 1, a, b);

                    if (result < 0) sb.append("-");
                    else if (result == 0) sb.append("0");
                    else sb.append("+");
                } else {
                    int n;
                    if (b < 0) n = -1;
                    else if (b == 0) n = 0;
                    else n = 1;
                    Update(1, N, 1, a, n);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int init(int start, int end, int node) {
        if (start >= end) return tree[node] = A[start];

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node*2) * init(mid+1, end, node*2+1);
    }

    public static int Multi(int start, int end, int node, int left, int right) {
        if (start > right || end < left) return 1;

        if (start >= left && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return Multi(start, mid, node*2, left, right) * Multi(mid+1, end, node*2+1, left, right);
    }

    public static int Update(int start, int end, int node, int index, int change) {
        if (start > index || end < index) return tree[node];

        if (start == end) return tree[node] = change;

        int mid = (start + end) / 2;
        
        return tree[node] = Update(start, mid, node*2, index, change) * Update(mid+1, end, node*2+1, index, change);
    }

}