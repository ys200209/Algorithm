import java.util.*;

public class Main2_2 {
    static int result=0;
    static String[][] map;
    static boolean isBomb;
    static boolean[][] bingo;

    public static void main(String[] args) {
        
        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"})); // 14 
        System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
        // 15 

    }

    public static int solution(int m, int n, String[] board) {
        
        map = new String[m][n];

        for(int i=0; i<m; i++) {
            map[i] = board[i].split("");
        }

        checkBingo();

        return result;
    }

    public static void checkBingo() {
        isBomb = false;
        bingo = new boolean[map.length][map[0].length];

        for(int i=0; i<map.length-1; i++) {
            for(int j=0; j<map[i].length-1; j++) {
                if (!map[i][j].equals("X")) { // 터지지 않은 블록만 탐색
                    String str = map[i][j];
                    if (map[i][j+1].equals(str) && map[i+1][j].equals(str) && map[i+1][j+1].equals(str)) {
                        isBomb = true;
                        bingo[i][j] = true;
                        bingo[i][j+1] = true;
                        bingo[i+1][j] = true;
                        bingo[i+1][j+1] = true;
                    }
                }
                
            }
        }

        if (isBomb) BingoBomb();

    }

    public static void BingoBomb() {
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if (bingo[i][j]) {
                    result++;
                    map[i][j] = "X";
                    for(int k=i-1; k>=0; k--) { // 제거된 블록의 공간으로 다른 블록 이동시키기
                        map[k+1][j] = map[k][j];
                        map[k][j] = "X";
                    }
                }
            }
        }

        checkBingo();

    }

}