package KAKAO_BLIND_RECRUITMENT.Kakao2023;

public class K4 {

    public static void main(String[] args) {
//        System.out.println(solution(new long[]{7, 5})); // [1, 0]
        System.out.println(solution(new long[]{63, 111, 95})); // [1, 1, 0]
    }

    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            String binary = binaryNumber(numbers[i]);
            System.out.println("binary = " + binary);
        }

        return answer;
    }

    private static String binaryNumber(long number) {
        StringBuilder sb = new StringBuilder();

        while(number > 0) {
            sb.append(number%2);
            number /= 2;
        }
//        sb.append(0);

        return sb.reverse().toString();
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

    public void inOrder(Node rootNode) {

        if (rootNode.leftNode != null) inOrder(rootNode.leftNode);
        System.out.print(rootNode.rootNode);
        if (rootNode.rightNode != null) inOrder(rootNode.rightNode);

    }

}