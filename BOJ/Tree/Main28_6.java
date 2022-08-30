import java.util.*;
import java.io.*;

public class Main28_6 {
    static int N;
    static Tree tree = new Tree();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            tree.add(root, left, right); // Ʈ���� ������ ��������
        }

        tree.preOrder(tree.rootNode); // preOrder
        System.out.println();
        tree.inOrder(tree.rootNode); // inOrder
        System.out.println();
        tree.postOrder(tree.rootNode); // postOrder
        
    }

    static class Tree {

        Node rootNode;

        public void add(String root, String left, String right) {
            if (rootNode == null) {
                rootNode = new Node(root);
                if (!left.equals(".")) rootNode.leftNode = new Node(left);
                if (!right.equals(".")) rootNode.rightNode = new Node(right);
            } else {
                search(rootNode, root, left, right);
            }
        }

        public void search(Node rootNode, String root, String left, String right) {
            if (rootNode == null) return;

            if (rootNode.rootNode.equals(root)) {
                if (!left.equals(".")) rootNode.leftNode = new Node(left);
                if (!right.equals(".")) rootNode.rightNode = new Node(right);
            } else {
                search(rootNode.leftNode, root, left, right);
                search(rootNode.rightNode, root, left, right);
            }
        }

        public void preOrder(Node root) {
            if (root == null) return;

            System.out.print(root.rootNode);
            preOrder(root.leftNode);
            preOrder(root.rightNode);
        }

        public void inOrder(Node root) {
            if (root == null) return;

            inOrder(root.leftNode);
            System.out.print(root.rootNode);
            inOrder(root.rightNode);
        }

        public void postOrder(Node root) {
            if (root == null) return;

            postOrder(root.leftNode);
            postOrder(root.rightNode);
            System.out.print(root.rootNode);
        }

    }

    static class Node {

        String rootNode;
        Node leftNode;
        Node rightNode;

        public Node(String rootNode) {
            this.rootNode = rootNode;
        }

    }

}

