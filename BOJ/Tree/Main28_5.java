import java.util.*;
import java.io.*;

public class Main28_5 {
    static int N;
    static Tree tree;
    static int[] in, post;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // preOrder : Root - Left - Right
        // inOrder : Left - Root - Right
        // postOrder : Left - Right - Root

        in = new int[N+1];
        post = new int[N+1];

        int i=1;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            in[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        i=1;
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            post[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        getPreOrder(1, N, 1, N);

    }

    public static void getPreOrder(int in_start, int in_end, int post_start, int post_end) {

        if (in_start > in_end || post_start > post_end) return;

        int root = post[post_end];
        sb.append(root + " ");

        


    }

}
