import java.util.*;
import java.io.*;

public class Main38_14427 {
    static int N, M;
    static Node[] A, tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new Node[N+1];
        tree = new Node[N*4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i=1;
        while(st.hasMoreTokens()) {
            A[i] = new Node(Integer.parseInt(st.nextToken()), i);
            i++;
        }

        M = Integer.parseInt(br.readLine());

        init(1, N, 1);

        for(i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int query = Integer.parseInt(st.nextToken());
            int X;
            int Y;

            if (query == 1) {
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());

                Update(1, N, 1, X, Y);
            } else {
                sb.append(tree[1].index + "\n");
            }
        }

        System.out.println(sb);

    }

    public static Node init(int start, int end, int node) {
        if (start == end) return tree[node] = A[start];

        int mid = (start + end) / 2;
        Node node1 = init(start, mid, node*2);
        Node node2 = init(mid+1, end, node*2+1);

        if (node1.value == node2.value) {
            if (node1.index < node2.index) tree[node] = node1;
            else tree[node] = node2;
        } else {
            if (node1.value < node2.value) tree[node] = node1;
            else tree[node] = node2;
        }

        return tree[node];
    }

    public static Node Update(int start, int end, int node, int index, int change) {
        if (start > index || end < index) return tree[node];

        if (start == end) return tree[node] = new Node(change, index);

        int mid = (start + end) / 2;
        Node node1 = Update(start, mid, node*2, index, change);
        Node node2 = Update(mid+1, end, node*2+1, index, change);

        if (node1 == null) tree[node] = node2;
        else if (node2 == null) tree[node] = node1;
        else {
            if (node1.value == node2.value) {
                if (node1.index < node2.index) tree[node] = node1;
                else tree[node] = node2;
            } else {
                if (node1.value < node2.value) tree[node] = node1;
                else tree[node] = node2;
            }
        }
        return tree[node];
    }

    static class Node {

        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

    }
}

