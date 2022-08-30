import java.util.*;
import java.io.*;

public class Main_16235 {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int N, M, K;
    static int[][] board, A;
    static Position[][] pos;
    static ArrayList<Position> treeList = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {

        init();
        
        for(int k=0; k<K; k++) {
            spring();
            summer();
            fall();
            winter();
        }

        int result = 0;

        for(Position position : treeList) {
            result += position.trees.size();
        }

        System.out.println(result);

    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N+1][N+1];
        A = new int[N+1][N+1];
        pos = new Position[N+1][N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=1;
            while(st.hasMoreTokens()) {
                A[i][j] = Integer.parseInt(st.nextToken());
                board[i][j] = 5;
                j++;
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (pos[x][y] == null) pos[x][y] = new Position(x, y, new ArrayList<>());
            
            pos[x][y].trees.add(new Tree(z, true)); // ������ ����, ���� ����
            treeList.add(pos[x][y]);
        }
    }

    public static void spring() { // ��
        for (Position position : treeList) {
            int x = position.x;
            int y = position.y;
            ArrayList<Tree> trees = position.trees;

            if (trees.size() > 1) { // �� ĭ�� ������ 2�� �̻��̶��
                Collections.sort(trees, (tree1, tree2) -> { // ���̰� ���� ������ ����
                    return tree1.age - tree2.age;
                });
            }

            for(Tree tree : trees) {
                if (board[x][y] >= tree.age) { // ����� ���� �� �ִٸ�
                    board[x][y] -= tree.age;
                    tree.age++;
                } else { // ����� ���� ���Ѵٸ�
                    tree.isAlive = false; // ���� ���θ� false�� ����
                }
            }

        }
    }

    public static void summer() { // ����
        ArrayList<Position> deadPosition = new ArrayList<>();

        for (Position position : treeList) {
            int x = position.x;
            int y = position.y;
            ArrayList<Tree> trees = position.trees;
            ArrayList<Tree> deadTree = new ArrayList<>();

            for(Tree tree : trees) {
                if (!tree.isAlive) { // ������ �׾��ٸ�
                    board[x][y] += (tree.age / 2); // ����� �ȴ�.
                    deadTree.add(tree);
                }
            }

            for(Tree tree : deadTree) {
                trees.remove(tree);
            }

            if (trees.size() == 0) deadPosition.add(position); // �ش� ���� ������ �������� �ʴ´ٸ� ��ü ����
        }

        for(Position position : deadPosition) {
            pos[position.x][position.y] = null;
            treeList.remove(position);
        }
    }

    public static void fall() { // ����
        ArrayList<Position> addPosition = new ArrayList<>();

        for (Position position : treeList) {
            int x = position.x;
            int y = position.y;
            ArrayList<Tree> trees = position.trees;

            for(Tree tree : trees) {
                if (tree.age % 5 == 0) { // ������ ���̰� 5�� ������ ����
                    for(int i=0; i<8; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx < 1 || nx > N || ny < 1 || ny > N) continue;

                        if (pos[nx][ny] == null) {
                            pos[nx][ny] = new Position(nx, ny, new ArrayList<>());
                            addPosition.add(pos[nx][ny]);
                        }

                        pos[nx][ny].trees.add(new Tree(1, true)); // 1���� ������ ����
                    }
                }
            }
        }

        for(Position position : addPosition) {
            treeList.add(position);
        }

    }

    public static void winter() { // �ܿ�
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                board[i][j] += A[i][j];
            }
        }
    }

    static class Position {

        int x;
        int y;
        ArrayList<Tree> trees = new ArrayList<>();

        public Position(int x, int y, ArrayList<Tree> trees) {
            this.x = x;
            this.y = y;
            this.trees = trees;
        }

    }

    static class Tree {

        int age;
        boolean isAlive;

        public Tree(int age, boolean isAlive) {
            this.age = age;
            this.isAlive = isAlive;
        }

    }

}
