import java.util.*;
import java.io.*;

public class Main28_4 {
    static int N;
    static Tree tree = new Tree();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            
            tree.add(root, left, right);
        }

        tree.preOrder(tree.rootNode);
        System.out.println();
        tree.inOrder(tree.rootNode);
        System.out.println();
        tree.postOrder(tree.rootNode);

    }
    
}

class Node {
    String rootNode;
    Node leftNode;
    Node rightNode;

    public Node(String rootNode) {
        this.rootNode = rootNode;
    }
}

class Tree {
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

        if (rootNode.rootNode.equals(root)) { // 탐색 도중 타겟 노드를 발견했다면
            if (!left.equals(".")) rootNode.leftNode = new Node(left);
            if (!right.equals(".")) rootNode.rightNode = new Node(right);
        } else {
            // 발견하지 못했다면 다른 자식 노드들을 탐색
            search(rootNode.leftNode, root, left, right);
            search(rootNode.rightNode, root, left, right);
        }

    }

    public void preOrder(Node rootNode) {
        
        System.out.print(rootNode.rootNode);
        if (rootNode.leftNode != null) preOrder(rootNode.leftNode);
        if (rootNode.rightNode != null) preOrder(rootNode.rightNode);

    }

    public void inOrder(Node rootNode) {

        if (rootNode.leftNode != null) inOrder(rootNode.leftNode);
        System.out.print(rootNode.rootNode);
        if (rootNode.rightNode != null) inOrder(rootNode.rightNode);

    }

    public void postOrder(Node rootNode) {

        if (rootNode.leftNode != null) postOrder(rootNode.leftNode);
        if (rootNode.rightNode != null) postOrder(rootNode.rightNode);
        System.out.print(rootNode.rootNode);

    }

}