package BOJ.Implementation;

import java.io.*;
import java.util.*;

public class Main2_16235 {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1 ,1, -1, 0, 1};
    static int N, M, K, year=0;
    static int[][] A, board, bank;
    static List<Tree> trees = new ArrayList<>();
    static Queue<Tree> summerQueue = new LinkedList<>();
    static Queue<Tree> fallQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        board = new int[N][N];
        bank = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                board[i][j] = 5;
                A[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

//            System.out.println("pos : (" + x + ", " + y + ", " + z + ")");

            trees.add(new Tree(x-1, y-1, z));
        }

        while(year < K) {

            spring();
            summer();
            fall();
//            winter();

            year++;
        }
        System.out.println(trees.size());
    }

    private static void spring() {
        Collections.sort(trees, Comparator.comparingInt(tree -> tree.age));

        for (Tree tree : trees) {
            int x = tree.x;
            int y = tree.y;
//            System.out.println("(" + x +", " + y +")");
            if (bank[x][y] < A[x][y] * year) {
                int amount = (A[x][y] * year) - bank[x][y];
                bank[x][y] += amount;
                board[x][y] += amount;
            }

            if (board[x][y] < tree.age) {
                summerQueue.offer(tree);
            } else {
                board[x][y] -= tree.age;
                tree.age++;
                if (tree.age % 5 == 0) {
                    fallQueue.offer(tree);
                }
            }

        }
    }

    private static void summer() {
        while(!summerQueue.isEmpty()) {
            Tree tree = summerQueue.poll();
            board[tree.x][tree.y] += (tree.age/2);
            trees.remove(tree);
        }
    }

    private static void fall() {
        while(!fallQueue.isEmpty()) {
            Tree tree = fallQueue.poll();
            int x = tree.x;
            int y = tree.y;



            for(int i=0; i<8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                trees.add(new Tree(nx, ny, 1));
            }
        }
    }

    static class Tree {
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

}