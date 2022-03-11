import java.util.*;
import java.io.*;

public class Main38_4 {
    static int N, M;
    static int[] list;
    static Node[] tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N];
        tree = new Node[N*4];

        for(int i=0; i<N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        init(0, N-1, 1);

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            Node result = searchNode(0, N-1, 1, left-1, right-1);
            sb.append(result.MIN + " " + result.MAX + "\n");
        }

        System.out.println(sb);

    }

    public static Node init(int start, int end, int node) {
        if (start >= end) return tree[node] = new Node(list[start], list[start]);

        int mid = (start + end) / 2;
        Node left = init(start, mid, node*2);
        Node right = init(mid+1, end, node*2 + 1);

        int min = Math.min(left.MIN, right.MIN);
        int max = Math.max(left.MAX, right.MAX);

        return tree[node] = new Node(min, max);
    }

    public static Node searchNode(int start, int end, int node, int left, int right) {
        if (start > right || end < left) return null;
        
        if (start >= left && end <= right) return tree[node];

        int mid = (start + end) / 2;
        Node leftNode = searchNode(start, mid, node*2, left, right);
        Node rightNode = searchNode(mid+1, end, node*2+1, left, right);
        if (leftNode != null && rightNode != null) {
            int min = Math.min(leftNode.MIN, rightNode.MIN);
            int max = Math.max(leftNode.MAX, rightNode.MAX);
            return new Node(min, max);
        }

        return leftNode == null ? rightNode : leftNode;
    }

}

class Node {

    int MIN;
    int MAX;

    public Node(int MIN, int MAX) {
        this.MIN = MIN;
        this.MAX = MAX;
    }

}