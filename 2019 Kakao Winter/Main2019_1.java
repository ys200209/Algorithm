import java.util.*;

public class Main2019_1 {

    public static void main(String[] args) {

        System.out.println(solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, 
                new int[]{1,5,3,5,1,2,1,4})); // 4

    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<moves.length; i++) {
            for(int j=0; j<board.length; j++) {
                if (board[j][moves[i]-1] != 0) {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == board[j][moves[i]-1]) {
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(board[j][moves[i]-1]);
                        }
                    } else {
                        stack.push(board[j][moves[i]-1]);
                    }
                    
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
    
}
