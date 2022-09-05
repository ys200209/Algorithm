package BOJ.Implementation;

import java.io.*;
import java.util.*;

public class Main2_11559 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N=12, M=6;
    static Block[][] board;
    static boolean[][] visited;
    static List<Block> blocks = new ArrayList<>();
    static Queue<Block> queue = new LinkedList<>();
    static Queue<Block> popQueue = new LinkedList<>();
    static boolean isPop = false;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new Block[N][M];

        for(int i=0; i<N; i++) {
            String[] split = br.readLine().split("");
            for(int j=0; j<M; j++) {
                if (split[j].equals(".")) {
                    board[i][j] = null;
                } else {
                    Block block = new Block(i, j, split[j]);
                    board[i][j] = block;
                    blocks.add(block);
                }
            }
        }
        System.out.println(startGame());
    }

    private static int startGame() {
        int count = 0; // 연쇄 횟수

        while(true) {
            visited = new boolean[N][M];
            isPop = false;

            for(int i=N-1; i>=0; i--) {
                for(int j=0; j<M; j++) {
                    if (board[i][j] != null && !visited[i][j]) {
                        isPop = blockCheck(board[i][j]);
                    }

//                    System.out.println("(" + i + ", " + j + ")");
//                    System.out.println("x : " + board[i][j].x + ", y : " + board[i][j].y);
                }
            }

            if (!isPop) break;

            replace(); // 블록 재정렬

//            print();

            count++;
        }

        return count;
    }

    private static void print() {
        System.out.println("-----------------------");
        for(int i=0; i<N; i++) {
            System.out.println();
            for(int j=0; j<M; j++) {
                System.out.print(board[i][j] == null ? "." : board[i][j].color);
            }
        }
        System.out.println();
    }

    private static void replace() {
        Collections.sort(blocks, (block1, block2) -> block2.x - block1.x);

        for(int i=0; i<blocks.size(); i++) {
            Block block = blocks.get(i);
            int x = block.x;
            int y = block.y;

            if (x + 1 >= N) continue;

            while(true) {
                if (x + 1 < N && board[x+1][y] == null) x++;
                else break;
            }

            board[block.x][y] = null;
            block.x = x;
            board[block.x][y] = block;

        }
    }

    private static boolean blockCheck(Block block) {
//        System.out.println("block = " + block);
        int count = 1; // 같은 블록 갯수

        queue.clear();
        popQueue.clear();

        queue.offer(block);
        popQueue.offer(block);
        visited[block.x][block.y] = true;

        while(!queue.isEmpty()) {
            Block pollBlock = queue.poll();
//            System.out.println("pollBlock = " + pollBlock);
            int x = pollBlock.x;
            int y = pollBlock.y;
            String color = pollBlock.color;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (board[nx][ny] == null || !board[nx][ny].color.equals(color)) continue;

                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.offer(board[nx][ny]);
                popQueue.offer(board[nx][ny]);
                count++;

            }
        }

//        System.out.println("(" + block.x + ", " + block.y + ") : " + block.color + " - " + count);

        if (count >= 4) {
            isPop = true;

            while(!popQueue.isEmpty()) {
                Block popBlock = popQueue.poll();
                int x = popBlock.x;
                int y = popBlock.y;

                board[x][y] = null;
                blocks.remove(popBlock);
            }
        }

        return isPop;
    }

    static class Block {

        int x;
        int y;
        String color;

        public Block(int x, int y, String color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

}
