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
            
            pos[x][y].trees.add(new Tree(z, true)); // 나무의 나이, 생존 여부
            treeList.add(pos[x][y]);
        }
    }

    public static void spring() { // 봄
        for (Position position : treeList) {
            int x = position.x;
            int y = position.y;
            ArrayList<Tree> trees = position.trees;

            if (trees.size() > 1) { // 한 칸에 나무가 2개 이상이라면
                Collections.sort(trees, (tree1, tree2) -> { // 나이가 적은 순부터 정렬
                    return tree1.age - tree2.age;
                });
            }

            for(Tree tree : trees) {
                if (board[x][y] >= tree.age) { // 양분을 먹을 수 있다면
                    board[x][y] -= tree.age;
                    tree.age++;
                } else { // 양분을 먹지 못한다면
                    tree.isAlive = false; // 생존 여부를 false로 변경
                }
            }

        }
    }

    public static void summer() { // 여름
        ArrayList<Position> deadPosition = new ArrayList<>();

        for (Position position : treeList) {
            int x = position.x;
            int y = position.y;
            ArrayList<Tree> trees = position.trees;
            ArrayList<Tree> deadTree = new ArrayList<>();

            for(Tree tree : trees) {
                if (!tree.isAlive) { // 나무가 죽었다면
                    board[x][y] += (tree.age / 2); // 양분이 된다.
                    deadTree.add(tree);
                }
            }

            for(Tree tree : deadTree) {
                trees.remove(tree);
            }

            if (trees.size() == 0) deadPosition.add(position); // 해당 땅에 나무가 존재하지 않는다면 객체 제거
        }

        for(Position position : deadPosition) {
            pos[position.x][position.y] = null;
            treeList.remove(position);
        }
    }

    public static void fall() { // 가을
        ArrayList<Position> addPosition = new ArrayList<>();

        for (Position position : treeList) {
            int x = position.x;
            int y = position.y;
            ArrayList<Tree> trees = position.trees;

            for(Tree tree : trees) {
                if (tree.age % 5 == 0) { // 나무의 나이가 5의 배수라면 번식
                    for(int i=0; i<8; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx < 1 || nx > N || ny < 1 || ny > N) continue;

                        if (pos[nx][ny] == null) {
                            pos[nx][ny] = new Position(nx, ny, new ArrayList<>());
                            addPosition.add(pos[nx][ny]);
                        }

                        pos[nx][ny].trees.add(new Tree(1, true)); // 1살인 나무를 생성
                    }
                }
            }
        }

        for(Position position : addPosition) {
            treeList.add(position);
        }

    }

    public static void winter() { // 겨울
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                board[i][j] += A[i][j];
            }
        }
    }


}

class Position {
    
    int x;
    int y;
    ArrayList<Tree> trees = new ArrayList<>();

    public Position(int x, int y, ArrayList<Tree> trees) {
        this.x = x;
        this.y = y;
        this.trees = trees;
    }

}

class Tree {

    int age;
    boolean isAlive;

    public Tree(int age, boolean isAlive) {
        this.age = age;
        this.isAlive = isAlive;
    }

}