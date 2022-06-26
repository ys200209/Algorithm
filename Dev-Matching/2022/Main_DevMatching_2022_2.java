import java.util.*;

public class Main_DevMatching_2022_2 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int countA=0, countB=0, countC=0, result=0;
    static String[][] board;
    static boolean[][] visited;
    static ArrayList<Cell> list = new ArrayList<>();
    
    public static void main(String[] args) {

        System.out.println(solution(new String[]{"??b", "abc", "cc?"}));
        // 2

        // System.out.println(solution(new String[]{"aa?"}));
        // 0
    }
    
    public static int solution(String[] grid) {
        board = new String[grid.length][grid[0].length()];

        for(int i=0; i<grid.length; i++) {
            board[i] = grid[i].split("");
            for(int j=0; j<grid[0].length(); j++) {
                if (board[i][j].equals("?")) list.add(new Cell(i, j));
            }
        }

        DFS(0, 0);

        return result;
    }

    public static void DFS(int index, int count) {
        if (count == list.size()) {
            countA = 0;
            countB = 0;
            countC = 0;
            visited = new boolean[board.length][board[0].length];

            for(int i=0; i<board.length; i++) {
                for(int j=0; j<board[0].length; j++) {
                    if (!visited[i][j]) {
                        if (board[i][j].equals("a")) countA++;
                        else if (board[i][j].equals("b")) countB++;
                        else countC++;

                        if (countA > 1 || countB > 1 || countC > 1) return;

                        BFS(board[i][j], i, j);
                    }
                }
            }
            result++;
            return;
        }

        for(int i=index; i<list.size(); i++) {
            for(int j=0; j<3; j++) {
                if (j == 0) board[list.get(i).row][list.get(i).column] = "a";
                else if (j == 1) board[list.get(i).row][list.get(i).column] = "b";
                else board[list.get(i).row][list.get(i).column] = "c";

                DFS(i+1, count+1);
            }
        }
    }

    public static void BFS(String str, int row, int column) {
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(row, column));
        visited[row][column] = true;

        while(!queue.isEmpty()) {
            Cell cell = queue.poll();
            int x = cell.row;
            int y = cell.column;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;

                if (visited[nx][ny]) continue;

                if (!board[nx][ny].equals(str)) continue;

                visited[nx][ny] = true;
                queue.offer(new Cell(nx, ny));
            }
        }
    }

}

class Cell {

    int row;
    int column;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

}