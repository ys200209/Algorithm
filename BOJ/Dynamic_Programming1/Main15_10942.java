import java.util.*;
import java.io.*;

public class Main15_10942 {
    static int N, M;
    static String[] A, tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new String[N+1];
        tree = new String[N*4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=1;
        while(st.hasMoreTokens()) {
            A[i] = st.nextToken();
            i++;
        }

        init(1, N, 1);
        // System.out.println(Arrays.toString(tree));

        M = Integer.parseInt(br.readLine());

        for(i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            if (i==0){
                if (X > Y) sb.append(Search(1, N, 1, Y, X));
                else sb.append(Search(1, N, 1, X, Y)); 
            } else {
                if (X > Y) sb.append("\n" + Search(1, N, 1, Y, X));
                else sb.append("\n" + Search(1, N, 1, X, Y)); 
            }

            
        }
        System.out.println(sb);
    }

    public static String init(int start, int end, int node) {
        if (start == end) return tree[node] = A[start];

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }

    public static String Search(int start, int end, int node, int left, int right) {
        if (start > right || end < left) return "";

        if (start >= left && end <= right) return tree[node];

        int mid = (start + end) / 2;
        String S = Search(start, mid, node*2, left, right) + Search(mid+1, end, node*2+1, left, right);

        if (node != 1) return S;

        if (S.length() % 2 == 0) { // ÆÓ¸°µå·ÒÀÌ Â¦¼ö¶ó¸é
            int front = S.length()/2-1;
            int back = S.length()/2;
            for(int i=back; i<S.length(); i++) {
                if (S.charAt(front) != S.charAt(back)) return "0";
                front--;
            }
        } else {
            int front = S.length()/2-1;
            int back = S.length()/2+1;
            for(int i=back; i<S.length(); i++) {
                if (S.charAt(front) != S.charAt(back)) return "0";
                front--;
            }
        }
        return "1";
    }

}