import java.util.*;
import java.io.*;

public class Main_11559 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static String[][] board = new String[12][6];
    static boolean[][] visited;
    static Queue<Block> blocks = new LinkedList<>();
    static boolean isBomb = true;
    static int result = -1;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<12; i++) {
            board[i] = br.readLine().split("");
        }

        checkBlock();

        System.out.println(result);
    }

    public static void checkBlock() {
        while(isBomb) {
            result++;
            isBomb = false;
            visited = new boolean[12][6];

            for(int i=11; i>=0; i--) {
                for(int j=0; j<6; j++) {
                    if (!board[i][j].equals(".") && !visited[i][j]) {
                        BFS(i, j);
                    }
                }
            }
            gravity(); // 삭제 후 위치 재정렬

        }
    }

    public static void BFS(int row, int column) { // 터질 블록을 탐색
        Queue<Block> bombBlocks = new LinkedList<>();
        bombBlocks.offer(new Block(row, column, board[row][column]));

        visited[row][column] = true;
        blocks.offer(new Block(row, column, board[row][column]));

        while(!blocks.isEmpty()) {
            Block block = blocks.poll();
            int x = block.x;
            int y = block.y;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;

                if (visited[nx][ny]) continue;

                if (board[nx][ny].equals(block.color)) {
                    visited[nx][ny] = true;
                    blocks.offer(new Block(nx, ny, block.color));
                    bombBlocks.offer(new Block(nx, ny, block.color));
                    isBomb = true;
                }
            }
        }

        if (bombBlocks.size() >= 4) {
            bomb(bombBlocks);
        }

    }

    public static void bomb(Queue<Block> bombBlocks) {
        while(!bombBlocks.isEmpty()) {
            Block block = bombBlocks.poll();

            board[block.x][block.y] = ".";
        }
    }

    public static void gravity() {
        for(int i=0; i<6; i++) {
            for(int j=11; j>=0; j--) {
                if (!board[j][i].equals(".")) { // 만약 블록이 존재한다면
                    for(int k=11; k>j; k--) {
                        if (board[k][i].equals(".")) { // 블록보다 아래에 빈 공간이 존재한다면 이동
                            board[k][i] = board[j][i];
                            board[j][i] = ".";
                            break;
                        }
                    }
                }
            }
        }
    }

}

class Block {

    int x;
    int y;
    String color;

    public Block(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

}